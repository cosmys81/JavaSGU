package org.knit.solutions.lab6;

public class Merge {
    public void merge(int[] destination, int countDest, int[] source, int countSource) {
        int destIndex = countDest - 1;      // Последний валидный элемент в destination
        int sourceIndex = countSource - 1;  // Последний элемент в source
        int insertPos = countDest + countSource - 1; // Позиция для вставки в destination

        // Сливаем два массива, начиная с конца
        while (destIndex >= 0 && sourceIndex >= 0) {
            if (destination[destIndex] > source[sourceIndex]) {
                destination[insertPos--] = destination[destIndex--];
            } else {
                destination[insertPos--] = source[sourceIndex--];
            }
        }

        // Если остались элементы в source, переносим их в destination
        while (sourceIndex >= 0) {
            destination[insertPos--] = source[sourceIndex--];
        }
    }
}
