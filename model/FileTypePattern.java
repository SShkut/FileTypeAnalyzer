package model;

public class FileTypePattern {

    private final String signature;
    private final String fileTypeDescription;

    public FileTypePattern(String signature, String fileTypeDescription) {
        this.signature = signature;
        this.fileTypeDescription = fileTypeDescription;
    }

    public String getSignature() {
        return signature;
    }

    public String getFileTypeDescription() {
        return fileTypeDescription;
    }
}
