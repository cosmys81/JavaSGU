package org.knit.solutions.lab5.task14;

/**
 * Посетитель для подсчёта общего размера файлов.
 */
public class SizeAnalyzer implements FileSystemVisitor {
    private int totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Folder folder) {
        for (FileSystemElement element : folder.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Shortcut shortcut) {
        // Игнорируем размер ярлыков
    }

    public int getTotalSize() {
        return totalSize;
    }
}
