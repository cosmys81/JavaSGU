package org.knit.solutions.lab5.task14;

public class File implements FileSystemElement {
    private final String fileName;
    private final int fileSize;
    private final boolean infected;

    public File(String fileName, int fileSize, boolean infected) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.infected = infected;
    }

    public int getSize() {
        return fileSize;
    }

    public boolean hasVirus() {
        return infected;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return fileName;
    }
}
