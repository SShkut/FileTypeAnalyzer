import analyzer.FileReader;
import analyzer.FileTypeAnalyzer;
import analyzer.FileTypeAnalyzerFactory;
import model.FileTypePattern;

public class Main {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.exit(0);
        }
        FileTypeAnalyzer analyzer = FileTypeAnalyzerFactory.getFileTypeAnalyzer("");
        String rootFolderName = args[0];
        FileTypePattern pattern = new FileTypePattern(args[1], args[2]);
        FileReader fileReader = new FileReader(analyzer, pattern);
        fileReader.printFilesTypes(rootFolderName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
