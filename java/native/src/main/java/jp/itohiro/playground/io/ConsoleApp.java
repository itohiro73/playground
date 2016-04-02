package jp.itohiro.playground.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by hiroshi on 6/2/15.
 */
public class ConsoleApp {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        int input;
        while((input = in.read()) != '\n'){
            bout.write(input);
        }
        System.out.println(bout.toString(Charset.defaultCharset().name()));
    }
}
