package jp.itohiro.playground.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hiroshi on 5/28/15.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket server = new ServerSocket(8073)){
            System.out.println("Waiting for establishing connection...");
            Socket socket = server.accept();
            System.out.println("Established connection!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line="";
            while(!"bye".equals(line)){
                line = reader.readLine();
                System.out.println(line);
            }
            socket.close();
        }
    }
}
