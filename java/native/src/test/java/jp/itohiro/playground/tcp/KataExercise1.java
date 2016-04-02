package jp.itohiro.playground.tcp;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by hiroshi on 5/30/15.
 */
public class KataExercise1 {
    @Before
    public void setUp(){

    }


    @Test
    public void testInputStreamOutputStream() throws Exception {
        // send a byte array
        final ServerSocket server = new ServerSocket(0);
        int port = server.getLocalPort();

        Thread serverThread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    server.accept();
                } catch (IOException e) {
                    new RuntimeException("Error accepting incoming request", e);
                }
            }
        });

        serverThread.start();
    }
}
