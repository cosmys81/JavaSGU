package org.knit.solutions.lab5.task14;

/**
 * Посетитель, сканирующий файлы на наличие вирусов.
 */
public class VirusScanner implements FileSystemVisitor {

    @Override
    public void visit(File file) {
        if (file.hasVirus()) {
            System.out.println("Обнаружен вирус в файле: " + file);
        }
    }

    @Override
    public void visit(Folder folder) {
        for (FileSystemElement element : folder.getElements()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(Shortcut shortcut) {
        // Ярлыки игнорируются при сканировании
    }
}
