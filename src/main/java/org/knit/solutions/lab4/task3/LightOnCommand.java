package org.knit.solutions.lab4.task3;

/**
 * Команда включения света.
 */
public class LightOnCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Свет включён!");
    }

    @Override
    public void undo() {
        System.out.println("Свет выключен!");
    }
}
