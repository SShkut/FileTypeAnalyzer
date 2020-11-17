package analyzer;

import java.util.List;

public interface FileTypeAnalyzer {
    String getFileType(byte[] data, List<FileTypePattern> patterns);
}
