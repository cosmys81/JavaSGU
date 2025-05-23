package org.knit.solutions.lab4.task3;

import java.util.Stack;

/**
 * Класс-исполнитель команд. Хранит историю для отмены.
 */
public class RemoteControl {

    private final Stack<Command> history = new Stack<>();

    /**
     * Выполнить команду и добавить её в историю.
     * @param cmd команда для выполнения
     */
    public void executeCommand(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }

    /**
     * Отменить последнюю выполненную команду, если есть.
     */
    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        } else {
            System.out.println("Отменять нечего, история пуста.");
        }
    }
}
