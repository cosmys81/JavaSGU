package org.knit.solutions.lab5.task14;

import java.util.ArrayList;
import java.util.List;

/**
 * Папка, содержащая элементы файловой системы.
 */
public class Folder implements FileSystemElement {
    private final String folderName;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public void addElement(FileSystemElement element) {
        children.add(element);
    }

    public List<FileSystemElement> getElements() {
        return children;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return folderName;
    }
}
