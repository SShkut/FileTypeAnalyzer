package analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class FileReader {

    private final FileTypeAnalyzer analyzer;
    private final List<FileTypePattern> patterns;

    public FileReader(FileTypeAnalyzer analyzer, List<FileTypePattern> patterns) {
        this.analyzer = analyzer;
        this.patterns = patterns;
    }

    public void printFilesTypes(String rootFolderName) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try (Stream<Path> files = Files.list(Path.of(rootFolderName))) {
            files.forEach((file) -> executor.submit(() -> System.out.println(file.getFileName() + ": " + getFileType(file))));
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
        return analyzer.getFileType(data, patterns);
    }
}
