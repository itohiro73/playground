package jp.itohiro.playground.io;

import org.junit.rules.ExternalResource;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileKataTestResource extends ExternalResource {
    public static final String RESOURCE_DIR = "src/test/resources/io";

//    public static final ImmutableList<String> DIRS = Lists.immutable.of(
//            "src/test/resources/io",
//            "src/test/resources/io/dir1",
//            "src/test/resources/io/dirToCopy",
//            "src/test/resources/io/dirToRecursiveCopy",
//            "src/test/resources/io/dirToRecursiveCopy/dir1",
//            "src/test/resources/io/dirToRecursiveCopy/dir2",
//            "src/test/resources/io/dirToRename"
//    );

//    public static final ImmutableList<String> FILES = Lists.immutable.of(
//            "src/test/resources/io/file1",
//            "src/test/resources/io/fileToCopy",
//            "src/test/resources/io/fileToMove",
//            "src/test/resources/io/fileToRead",
//            "src/test/resources/io/fileToRename",
//            "src/test/resources/io/dirToRecursiveCopy/file1",
//            "src/test/resources/io/dirToRecursiveCopy/dir1/file2"
//    );
    public static final String READ_FILE_CONTENTS = "Hello Java World.";
    public static final String COPY_FILE_CONTENTS = "Correct copy file.";
    public static final String MOVE_FILE_CONTENTS = "Correct move file.";
    public static final String RENAME_FILE_CONTENTS = "Correct rename file.";

    @Override
    protected void before() throws Throwable {
        this.recreateFileResources();
    }

    @Override
    protected void after() {
        try {
            this.recreateFileResources();
        } catch (IOException e) {
            throw new RuntimeException("Clean-up might have failed..", e);
        }
    }

    private void recreateFileResources() throws IOException {
        this.clean(Paths.get(RESOURCE_DIR));
//        DIRS.each(Procedures.throwing(dir -> Files.createDirectory(Paths.get(dir))));
//        FILES.each(Procedures.throwing(file -> Files.createFile(Paths.get(file))));
        this.writeFileContents();
    }

    private void writeFileContents() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/test/resources/io/fileToRead"));
        writer.write(READ_FILE_CONTENTS);
        writer.close();
        writer = Files.newBufferedWriter(Paths.get("src/test/resources/io/fileToCopy"));
        writer.write(COPY_FILE_CONTENTS);
        writer.close();
        writer = Files.newBufferedWriter(Paths.get("src/test/resources/io/fileToMove"));
        writer.write(MOVE_FILE_CONTENTS);
        writer.close();
        writer = Files.newBufferedWriter(Paths.get("src/test/resources/io/fileToRename"));
        writer.write(RENAME_FILE_CONTENTS);
        writer.close();

    }

    private void clean(Path path) throws IOException {
        if(!Files.exists(path)){
            return;
        }
        if(Files.isRegularFile(path)){
            Files.delete(path);
        }
        else{
            Files.list(path).forEach(eachPath -> {
                try {
                    clean(eachPath);
                } catch (IOException e) {
                    throw new RuntimeException("Resources may not have been cleaned-up... " +
                            "Manually delete files under \"src/test/resources/io\" and rerun", e);
                }
            });
            Files.delete(path);
        }
    }
}

