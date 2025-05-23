package org.knit.solutions.lab5.task14;

/**
 * Элемент файловой системы, который может принимать посетителя.
 */
interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
