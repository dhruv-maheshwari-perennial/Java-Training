package Basic_IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Paths_08 {
    public static void main(String[] args) {
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path path) throws IOException {
//                return (Files.isRegularFile(path));
//            }
//        };

        // lambda method
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
//        Path directory = FileSystems.getDefault().getPath("Examples/Dir2");
        Path directory = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir2");

        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file: contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);

        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        // creating temp file
        try {
            Path tempFile = Files.createTempFile("myapp",".appext");
            System.out.println("Temp File Path: " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store: stores) {
            System.out.println("Volume: " + store);
            System.out.println("File Store: " + store.name());
        }

        System.out.println("-----------------");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path: rootPaths) {
            System.out.println(path);
        }
    }
}
