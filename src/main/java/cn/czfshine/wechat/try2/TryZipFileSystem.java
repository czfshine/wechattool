package cn.czfshine.wechat.try2;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;

public class TryZipFileSystem {
    public static void main(String[] arg){
        HashMap<String, String> zp = new HashMap<>();

        /* set create to true if you want to create a new ZIP file */
        zp.put("create", "true");
        zp.put("encoding","UTF-8");
        URI uri = URI.create("jar:file:/D:/wc/data/image/image2.zip");

        try {
            final int[] maxcount = {100};
            FileSystem fs = FileSystems.newFileSystem(uri, zp);
            Files.walkFileTree(fs.getPath("/"), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if(maxcount[0] >0){
                        System.out.println(file.toString());
                        maxcount[0] -= 1;
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }
}
