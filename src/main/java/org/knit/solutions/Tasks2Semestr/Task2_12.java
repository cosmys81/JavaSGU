package org.knit.solutions.Tasks2Semestr;


import org.knit.solutions.Solution;
import org.knit.solutions.lab4.task2.Caretaker;
import org.knit.solutions.lab4.task2.TextEditor;

import org.knit.TaskDescription;

/**
 * Задача 12: Реализация системы отмены изменений в текстовом редакторе
 * <p>
 * Описание:
 * - Класс TextEditor содержит текущий текст документа.
 * - Класс Memento хранит снимок состояния текста для возможности отката изменений.
 * - Класс Caretaker управляет историей изменений (стек сохранённых состояний).
 * - Методы saveState() и undo() сохраняют и откатывают изменения.
 * - Возможность нескольких уровней отката изменений.
 */

@TaskDescription(
        taskNumber = 12,
        taskDescription = "Отмена изменений в текстовом редакторе",
        href = "org/knit/solutions/taskExampleClasses/README.md"
)
public class Task2_12 implements Solution {

    @Override
    public void execute() {
        Caretaker historyManager = new Caretaker();

        TextEditor firstNote = new TextEditor("Hello world!");
        historyManager.backup(firstNote);
        historyManager.showCurrent();

        TextEditor secondNote = new TextEditor("How are you?");
        historyManager.backup(secondNote);
        historyManager.showCurrent();

        TextEditor thirdNote = new TextEditor("Всё хорошо!");
        historyManager.backup(thirdNote);
        historyManager.showCurrent();

        System.out.println("\nВыполняем поэтапный откат сохранённых состояний:\n");

        historyManager.revert();
        historyManager.showCurrent();

        historyManager.revert();
        historyManager.showCurrent();

        historyManager.revert();

        historyManager.revert();
        historyManager.showCurrent();
    }
}

