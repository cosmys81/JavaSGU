package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.Random;

/**
 * Задача 17: Реализация и проверка парадокса Монти Холла
 * <p>
 * Описание:
 * - Участник выбирает одну из трёх дверей.
 * - Ведущий открывает одну из оставшихся дверей, за которой нет приза.
 * - Участник может либо сменить выбор, либо оставить его неизменным.
 * <p>
 * Требования:
 * - Реализовать симуляцию игры на Java.
 * - Провести большое количество экспериментов (например, 1 000 000).
 * - Подсчитать вероятность выигрыша в каждом из двух случаев.
 * <p>
 * Ожидаемый результат:
 * - Вероятность выигрыша при смене выбора ≈ 66.66% (2/3).
 * - Вероятность выигрыша без смены ≈ 33.33% (1/3).
 */


@TaskDescription(taskNumber = 17,
        taskDescription = "Проверка парадокса Монти Холла",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_17 implements Solution {

    private static final int SIMULATION_COUNT = 1_000_000;

    public void execute() {
        Random rnd = new Random();

        int winsWhenSwitch = 0;
        int winsWhenStay = 0;

        for (int i = 0; i < SIMULATION_COUNT; i++) {
            int prizeDoor = rnd.nextInt(3);
            int playerPick = rnd.nextInt(3);

            int hostReveal;
            do {
                hostReveal = rnd.nextInt(3);
            } while (hostReveal == prizeDoor || hostReveal == playerPick);

            int doorLeft = 3 - playerPick - hostReveal;

            if (doorLeft == prizeDoor) {
                winsWhenSwitch++;
            }

            if (playerPick == prizeDoor) {
                winsWhenStay++;
            }
        }

        System.out.printf("Вероятность выигрыша при смене: %.2f%%%n", (winsWhenSwitch / (double) SIMULATION_COUNT) * 100);
        System.out.printf("Вероятность выигрыша при сохранении выбора: %.2f%%%n", (winsWhenStay / (double) SIMULATION_COUNT) * 100);
    }
}
