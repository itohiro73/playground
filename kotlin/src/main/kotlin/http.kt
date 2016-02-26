import java.net.InetSocketAddress
import java.net.StandardSocketOptions
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.AsynchronousSocketChannel
import java.util.*
import java.util.concurrent.TimeUnit

class HttpServer {
    val server = AsynchronousServerSocketChannel.open()

    init {
        server.setOption(StandardSocketOptions.SO_REUSEADDR, true)
        server.bind(InetSocketAddress(8080));
    }

    fun start() {
        while (true) {
            print("Server started.")
            val acceptFuture = server.accept();
            handleRequest(acceptFuture.get());
        }
    }

    fun handleRequest(channel: AsynchronousSocketChannel) {

        val buff = ByteBuffer.allocateDirect(8192);
        channel.read(buff).get(10, TimeUnit.SECONDS);

        printRequest(buff);
        mkResponse(buff);
        buff.flip();
        channel.write(buff).get(10, TimeUnit.SECONDS);
    }

    private fun printRequest(buff: ByteBuffer) {
        buff.flip();
        val bytes = ByteArray(buff.limit())
        buff.get(bytes);
        buff.compact();
        print(String(bytes))
    }

    private fun mkResponse(buff: ByteBuffer) {
        buff.clear();
        val text = "HTTP/1.1 200 OK\n\n" + Date() + " (" + Thread.currentThread() + ")";
        buff.put(text.toByteArray());
    }
}

fun main(args: Array<String>) {
    print("Server started.")
    HttpServer().start()
}