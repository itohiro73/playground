package jp.itohiro.playground.io;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by hiroshi on 6/3/15.
 */
public class FileDirectoryTest {
    @Test
    public void testFilePath() throws Exception {
        FileSystem fs = FileSystems.getDefault();
        Path currendDir = fs.getPath(".");
        try(DirectoryStream<Path> ds = Files.newDirectoryStream(currendDir)){
            for(Path path : ds){
                System.out.println(path.toAbsolutePath());
            }
        }


    }
}
