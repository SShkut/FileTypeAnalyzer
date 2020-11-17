package analyzer;

import model.FileTypePattern;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileReader {

    private final FileTypeAnalyzer analyzer;
    private final FileTypePattern pattern;

    public FileReader(FileTypeAnalyzer analyzer, FileTypePattern pattern) {
        this.analyzer = analyzer;
        this.pattern = pattern;
    }

    public void printFilesTypes(String rootFolderName) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            Files.list(Path.of(rootFolderName))
                    .forEach((file) -> executor.submit(() -> System.out.println(file.getFileName() + ": " + getFileType(file))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    private String getFileType(Path path) {
        byte[] data = new byte[0];
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return analyzer.getFileType(data, pattern);
    }
}
