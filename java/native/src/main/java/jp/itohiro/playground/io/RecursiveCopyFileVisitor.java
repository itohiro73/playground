package jp.itohiro.playground.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by hiroshi on 6/9/15.
 */
public class RecursiveCopyFileVisitor extends SimpleFileVisitor<Path> {

    private Path src;
    private Path dist;

    protected RecursiveCopyFileVisitor(Path src, Path dist) {

        this.src = src;
        this.dist = dist;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path target = dist;
        if(!dir.equals(src)){
            target = dist.resolve(dir.getName(src.getNameCount()));
        }
        System.out.println("previsitDirectory: " + "dir:"+dir + ", dist:"+target);
        Files.copy(dir, target, StandardCopyOption.COPY_ATTRIBUTES);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path target = dist.resolve(file.getName(src.getNameCount())).resolve(file.getFileName());
        System.out.println("visitFile: " + "file:"+file + ", target:"+target);
        Files.copy(file, target, StandardCopyOption.COPY_ATTRIBUTES);
        return FileVisitResult.CONTINUE;
    }
}
