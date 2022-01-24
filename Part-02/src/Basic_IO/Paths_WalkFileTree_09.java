package Basic_IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class WalkFileTree extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " - " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}

class CpyEntireTree extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CpyEntireTree(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativePath = sourceRoot.relativize(file);
        System.out.println("Relative Path: " + relativePath);

        Path copyDir = targetRoot.resolve(relativePath);
        System.out.println("Resolved Path for Copy: " + copyDir);

        try {
            Files.copy(file, copyDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path relativePath = sourceRoot.relativize(dir);
        System.out.println("Relative Path: " + relativePath);

        Path copyDir = targetRoot.resolve(relativePath);
        System.out.println("Resolved Path for Copy: " + copyDir);

        try {
            Files.copy(dir, copyDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " - " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}

public class Paths_WalkFileTree_09 {
    public static void main(String[] args) {
        System.out.println("Walking File Tree Dir2");

        Path dir2Path = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new WalkFileTree());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---- Copy Dir2 -> Dir4/Dir2Copy -----");
        Path copyPath = FileSystems.getDefault().getPath("Examples" + File.separator + "Dir4" + File.separator + "Dir2Copy");

        try {
            Files.walkFileTree(dir2Path, new CpyEntireTree(dir2Path, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
