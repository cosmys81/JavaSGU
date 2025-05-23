package org.knit.solutions.lab6;

public class DuplicateZeros {
    public void duplicateZeros(int[] array) {
        int length = array.length;
        int zerosToDuplicate = 0;

        // Подсчитываем количество нулей, которые можем продублировать
        for (int value : array) {
            if (value == 0) {
                zerosToDuplicate++;
            }
        }

        int originalIndex = length - 1;
        int newIndex = length + zerosToDuplicate - 1;

        // Обрабатываем массив с конца, копируя элементы и дублируя нули
        while (originalIndex >= 0) {
            if (newIndex < length) {
                array[newIndex] = array[originalIndex];
            }
            newIndex--;

            if (array[originalIndex] == 0) {
                if (newIndex < length) {
                    array[newIndex] = 0;
                }
                newIndex--;
            }
            originalIndex--;
        }
    }
}
