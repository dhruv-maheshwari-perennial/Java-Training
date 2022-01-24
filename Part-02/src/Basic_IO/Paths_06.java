package Basic_IO;

import java.io.IOException;
import java.nio.file.*;

public class Paths_06 {
    public static void main(String[] args) {
        try {

            // delete file
            Path fileToDelete = FileSystems.getDefault().getPath("Examples","Dir1","file1Copy.txt");
            Files.deleteIfExists(fileToDelete);

            // move & replace file
//            Path filesToMove = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Files.move(filesToMove, destination);

            // copy file
//            Path sourceFilePath = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path copyFilePath = FileSystems.getDefault().getPath("Examples","file1Copy.txt");
//            Files.copy(sourceFilePath,copyFilePath, StandardCopyOption.REPLACE_EXISTING);

//            sourceFilePath = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFilePath = FileSystems.getDefault().getPath("Examples","Dir4");
//            Files.copy(sourceFilePath,copyFilePath,StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
