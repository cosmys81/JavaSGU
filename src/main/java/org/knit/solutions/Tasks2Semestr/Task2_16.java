package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.lab5.task16.CharacterFactory;
import org.knit.solutions.lab5.task16.TextCharacter;
import org.knit.solutions.Solution;

/**
 * Задача 16: Паттерн Приспособленец (Flyweight) для отображения символов
 * <p>
 * Описание:
 * - Каждый символ (Character) имеет внутреннее состояние (код символа).
 * - Внешнее состояние (координаты x, y и стиль) передаётся при отрисовке.
 * - Фабрика приспособленцев повторно использует объекты символов для оптимизации памяти.
 * <p>
 * Требования:
 * - Реализовать класс CharacterFlyweight для хранения внутреннего состояния символа.
 * - Реализовать метод render(x, y, style) для отображения символа с внешними параметрами.
 * - Использовать фабрику CharacterFactory для управления объектами символов.
 */

@TaskDescription(
        taskNumber = 16,
        taskDescription = "Паттерн Приспособленец (Flyweight)",
        href = "org/knit/solutions/taskExampleClasses/README.md"
)
public class Task2_16 implements Solution {

    @Override
    public void execute() {
        String text = "Hello, World!";
        int x = 0, y = 0;
        String style = "Times New Roman, 14pt";

        for (char c : text.toCharArray()) {
            TextCharacter character = CharacterFactory.getCharacter(c);
            character.render(x, y, style);
            x += 1; // Смещаем координату для следующего символа
        }
    }
}
