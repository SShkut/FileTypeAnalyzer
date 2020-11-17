package analyzer;

import model.FileTypePattern;

public class NaiveFileTypeAnalyzer implements FileTypeAnalyzer {

    @Override
    public String getFileType(byte[] data, FileTypePattern fileTypePattern) {
        byte[] pattern = fileTypePattern.getSignature().getBytes();
        for (int i = 0; i < data.length - pattern.length + 1; ++i) {
            boolean match = true;
            for (int j = 0; j < pattern.length; ++j) {
                if (data[i + j] != pattern[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return fileTypePattern.getFileTypeDescription();
            }
        }

        return "Unknown file type";
    }
}
