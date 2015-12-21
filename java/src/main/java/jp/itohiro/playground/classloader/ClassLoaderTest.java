package jp.itohiro.playground.classloader;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;

public class ClassLoaderTest {
    public static ClassLoader createClassLoader(String dirName) throws IOException {
        URL[] url = new URL[1];
        url[0] = Paths.get(dirName).toFile().toURI().toURL();

        ClassLoader parent = ClassLoader.getSystemClassLoader();
        return new URLClassLoader(url, parent);
    }
}