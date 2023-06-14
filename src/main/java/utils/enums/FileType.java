package utils.enums;

public enum FileType {

    JSON(".json"),
    XML(".xml"),
    XSD(".xsd");

    private final String extension;

    FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
