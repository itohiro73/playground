package jp.itohiro.playground.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Created by hiroshi on 5/28/15.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 8073)){
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            while(!"bye".equals(line)){
                line = reader.readLine();
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
        }
    }
}
