package org.knit.solutions.lab5.task14;

/**
 * Интерфейс посетителя для элементов файловой системы.
 */
interface FileSystemVisitor {
    void visit(File file);
    void visit(Folder folder);
    void visit(Shortcut shortcut);
}
