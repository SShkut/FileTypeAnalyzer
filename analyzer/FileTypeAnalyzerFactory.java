package analyzer;

public class FileTypeAnalyzerFactory {

    /*not used in this version
    KmpFileTypeAnalyzer will be returned*/
    public static final String NAIVE = "--naive";
    public static final String KMP = "--KMP";

    public static FileTypeAnalyzer getFileTypeAnalyzer(String type) {
        if (type.equals(NAIVE)) {
            return new NaiveFileTypeAnalyzer();
        } else if (type.equals(KMP)) {
            return new KmpFileTypeAnalyzer();
        }
        return new KmpFileTypeAnalyzer();
    }
}
