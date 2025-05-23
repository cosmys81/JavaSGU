package org.knit.solutions.lab4.task3;

/**
 * Команда выключения телевизора.
 */
public class TVOffCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Телевизор выключен!");
    }

    @Override
    public void undo() {
        System.out.println("Телевизор включён!");
    }
}
