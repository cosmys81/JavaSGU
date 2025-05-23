package org.knit.solutions.lab4.task2;

import java.util.Stack;

/**
 * Хранитель состояний редактора.
 * Отвечает за сохранение и восстановление истории текста.
 */
public class Caretaker {
    private final Stack<Memento> history = new Stack<>();

    public void backup(TextEditor editor) {
        history.push(editor.createSnapshot());
        System.out.println("Состояние текста сохранено.");
    }

    public void revert() {
        if (!history.isEmpty()) {
            history.pop();
            System.out.println("Выполнен откат к предыдущему состоянию!");
        } else {
            System.out.println("Нет доступных сохранений для отката.");
        }
    }

    public void showCurrent() {
        if (!history.isEmpty()) {
            Memento current = history.peek();
            System.out.println("Текущий сохранённый текст: " + current.getContent());
        } else {
            System.out.println("Сохранённых текстов пока нет.");
        }
    }
}
