package analyzer;

import model.FileTypePattern;

public interface FileTypeAnalyzer {
    String getFileType(byte[] data, FileTypePattern fileTypePattern);
}
