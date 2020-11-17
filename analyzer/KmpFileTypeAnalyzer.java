package analyzer;

import java.util.List;

public class KmpFileTypeAnalyzer implements FileTypeAnalyzer {

    @Override
    public String getFileType(byte[] data, List<FileTypePattern> patterns) {
        for (FileTypePattern fileTypePattern : patterns) {
            char[] pattern = fileTypePattern.getSignature().toCharArray();
            int[] prefixFunction = getPrefixFunction(fileTypePattern.getSignature());
            //current symbol of the pattern
            int j = 0;
            for (int i = 0; i < data.length; ++i) {
                while (j > 0 && data[i] != pattern[j]) {
                    j = prefixFunction[j - 1];
                }
                if (data[i] == pattern[j]) {
                    j++;
                }
                if (j == pattern.length) {
                    return fileTypePattern.getFileTypeDescription();
                }
            }
        }

        return "Unknown file type";
    }

    private int[] getPrefixFunction(String pattern) {
        int[] prefixFunction = new int[pattern.length()];
        for (int i = 1; i < pattern.length(); ++i) {
            int border = prefixFunction[i - 1];
            while (border > 0 && pattern.charAt(i) != pattern.charAt(border)) {
                border = prefixFunction[border - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(border)) {
                border++;
            }
            prefixFunction[i] = border;
        }
        return prefixFunction;
    }
}
