package org.knit.solutions.lab4.task3;

/**
 * Команда включения телевизора.
 */
public class TVOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Телевизор включён!");
    }

    @Override
    public void undo() {
        System.out.println("Телевизор выключен!");
    }
}
