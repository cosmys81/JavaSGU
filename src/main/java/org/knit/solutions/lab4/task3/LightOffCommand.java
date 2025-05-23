package org.knit.solutions.lab4.task3;

/**
 * Команда выключения света.
 */
public class LightOffCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Свет выключен!");
    }

    @Override
    public void undo() {
        System.out.println("Свет снова включён!");
    }
}
