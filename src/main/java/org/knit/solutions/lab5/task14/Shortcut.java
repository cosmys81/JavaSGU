package org.knit.solutions.lab5.task14;

/**
 * Ярлык (ссылка) на элемент файловой системы.
 */
public class Shortcut implements FileSystemElement {
    private final FileSystemElement targetElement;

    public Shortcut(FileSystemElement targetElement) {
        this.targetElement = targetElement;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
