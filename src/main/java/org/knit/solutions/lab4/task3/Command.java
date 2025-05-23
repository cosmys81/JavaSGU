package org.knit.solutions.lab4.task3;

/**
 * Общий интерфейс для всех команд.
 * Определяет методы выполнения и отмены операции.
 */
public interface Command {
    void execute();
    void undo();
}
