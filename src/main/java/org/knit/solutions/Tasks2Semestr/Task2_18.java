package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.lab6.DuplicateZeros;
import org.knit.solutions.Solution;

import java.util.Arrays;


/**
 * Задача 18: Дублирование нулей в массиве
 * <p>
 * Описание:
 * - Необходимо продублировать каждое вхождение нуля в массиве.
 * - При этом элементы сдвигаются вправо, а выходящие за границы отбрасываются.
 * - Изменения выполняются на месте без создания нового массива.
 * <p>
 * Требования:
 * - Реализовать метод duplicateZeros(int[] arr) для модификации массива in-place.
 * - Написать JUnit тесты для проверки работы метода:
 * - Обычные случаи (с нулями и без).
 * - Краевые случаи (пустые массивы, все нули, нули на границах).
 * - Производительность (большие массивы, замер времени выполнения).
 */


@TaskDescription(taskNumber = 18,
        taskDescription = "JUnit тесты для проверки дублирования нулей в массиве",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_18 implements Solution {

    @Override
    public void execute() {
        DuplicateZeros duplicator = new DuplicateZeros();

        int[] example1 = {0, 7, 0, 4};
        System.out.println("Исходный массив: " + Arrays.toString(example1));
        duplicator.duplicateZeros(example1);
        System.out.println("После дублирования: " + Arrays.toString(example1));

        int[] example2 = {1, 2, 3};
        System.out.println("Исходный массив: " + Arrays.toString(example2));
        duplicator.duplicateZeros(example2);
        System.out.println("После дублирования: " + Arrays.toString(example2));

        int[] example3 = {0, 1, 2, 3, 4, 0};
        System.out.println("Исходный массив: " + Arrays.toString(example3));
        duplicator.duplicateZeros(example3);
        System.out.println("После дублирования: " + Arrays.toString(example3));
    }
}