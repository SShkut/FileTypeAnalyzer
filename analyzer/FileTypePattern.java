package analyzer;

public class FileTypePattern {

    //1;"%PDF-";"PDF document" CSV format for this model
    private final Integer priority;
    private final String signature;
    private final String fileTypeDescription;

    public FileTypePattern(Integer priority, String signature, String fileTypeDescription) {
        this.priority = priority;
        this.signature = signature;
        this.fileTypeDescription = fileTypeDescription;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getSignature() {
        return signature;
    }

    public String getFileTypeDescription() {
        return fileTypeDescription;
    }
}
