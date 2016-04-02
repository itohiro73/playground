package jp.itohiro.playground.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by hiroshi on 6/2/15.
 */
public class InputOutputTest {
    @Test
    public void testByteArrayInputOutput() throws Exception {
        System.out.println("Default encoding is: " + System.getProperty("file.encoding"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] message = "test".getBytes();
        out.write(message);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

        int b;
        while((b = in.read()) != -1){
            System.out.print(b);
        }
    }
}
