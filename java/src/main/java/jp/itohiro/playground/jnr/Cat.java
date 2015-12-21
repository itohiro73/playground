package jp.itohiro.playground.jnr;

import jnr.constants.platform.OpenFlags;
import jnr.posix.POSIX;
import jnr.posix.POSIXFactory;

public class Cat {
    private static POSIX posix = POSIXFactory.getPOSIX();

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Usage: " + args[0] + " <filename(s)>!");
        }

        for(int i=1; i<args.length; i++)
        {
            cat(args[i]);
        }

    }

    private static void cat(String filename) {
        int fd = posix.open(filename, OpenFlags.O_RDONLY.intValue(), 0444);

        if(fd < 0) throw new RuntimeException("Error opening file: " + filename);

        int ssize;
        byte[] buf = new byte[4096];

        while(true){
            ssize = posix.read(fd, buf, buf.length);
            if(ssize < 0) throw new RuntimeException("Error reading file: " + filename);
            if(ssize == 0) break;
            if(posix.write(1, buf, ssize) < 0) throw new RuntimeException("error writing to standard output");
        }

        if(posix.close(fd) < 0) throw new RuntimeException("Error closing file descriptor for " + filename);
    }
}
