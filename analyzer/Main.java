package analyzer;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.exit(0);
        }
        String rootFolderName = args[0];
        String dbPath = args[1];
        PatternRepository repository = new PatternRepository(dbPath);
        List<FileTypePattern> patterns = repository.getPatterns();
        patterns.sort(Comparator.comparing(FileTypePattern::getPriority, Comparator.reverseOrder()));
        FileReader fileReader = new FileReader(new KmpFileTypeAnalyzer(), patterns);
        fileReader.printFilesTypes(rootFolderName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
