package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.knit.solutions.lab4.task3.*;

/**
 * Задача №13: Имплементация паттерна Команда для умного дома
 *
 * Описание задачи:
 * - Интерфейс Command определяет выполнение и отмену команды.
 * - Классы LightOnCommand, LightOffCommand, TVOnCommand, TVOffCommand реализуют команды управления устройствами.
 * - RemoteControl выступает как исполнитель команд и хранит историю для отмены.
 * - Возможность отмены последней выполненной команды.
 */
@TaskDescription(
        taskNumber = 13,
        taskDescription = "Паттерн Команда: управление устройствами умного дома",
        href = "org/knit/solutions/taskExampleClasses/README.md"
)
public class Task2_13 implements Solution {

    @Override
    public void execute() {
        RemoteControl remote = new RemoteControl();

        Command switchLightOn = new LightOnCommand();
        Command switchLightOff = new LightOffCommand();

        Command switchTVOn = new TVOnCommand();
        Command switchTVOff = new TVOffCommand();

        System.out.println("Старт управления умным домом:");

        remote.executeCommand(switchLightOn);
        remote.executeCommand(switchLightOff);
        remote.executeCommand(switchTVOn);
        remote.executeCommand(switchTVOff);

        System.out.println("\nВыполнение отмены последних команд:");
        remote.undoLastCommand();
        remote.undoLastCommand();
        remote.undoLastCommand();
        remote.undoLastCommand();
        remote.undoLastCommand();  // Проверка на пустую историю
    }
}
