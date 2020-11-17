package analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatternRepository {

    private final String filePath;

    public PatternRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<FileTypePattern> getPatterns() {
        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            return stream.map(this::convertToPattern)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private FileTypePattern convertToPattern(String data) {
        String[] patternData = data.split(";");
        return new FileTypePattern(
                Integer.parseInt(patternData[0]),
                patternData[1].replace("\"", ""),
                patternData[2].replace("\"", "")
        );
    }
}
