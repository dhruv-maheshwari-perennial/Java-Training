package Basic_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Paths_05 {
    public static void main(String[] args) {
        // relative path
        Path path = FileSystems.getDefault().getPath("WorkingDirectory.txt");
        printFile(path);

//        Path subPath = FileSystems.getDefault().getPath("Files","SubDirectory.txt");
        Path subPath = Paths.get(".","Files","SubDirectory.txt");
        printFile(subPath);

        // absolute path
        subPath = Paths.get("C:\\Users\\dhruv\\Desktop","\\Perennial System","\\OutDirectory.txt");
        printFile(subPath);

        subPath = Paths.get(".");
        System.out.println(subPath.toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".","Files","..","Files","SubDirectory.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());

        Path path3 = FileSystems.getDefault().getPath("NotExists.txt");
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("Z://","adbcfe","watever.txt");
        System.out.println(path4.toAbsolutePath());

        subPath = FileSystems.getDefault().getPath("Files");
        System.out.println("Exists: " + Files.exists(subPath));

        System.out.println("Exists: " + Files.exists(path4));
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;

            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
