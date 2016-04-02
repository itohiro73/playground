package jp.itohiro.playground.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * Created by hiroshi on 5/28/15.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 8073)){
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), Charset.defaultCharset()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
            String line = "";
            while(!"bye".equals(line)){
                line = reader.readLine();
                if(line!=null){
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush();
            }
        }
    }
}
