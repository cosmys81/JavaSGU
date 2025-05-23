package org.knit.solutions.lab5.task16;

/**
 * Класс, представляющий внутреннее состояние символа.
 */
public class TextCharacter {
    private final char symbol; // Внутреннее состояние символа

    public TextCharacter(char symbol) {
        this.symbol = symbol;
    }

    public void render(int x, int y, String style) {
        System.out.printf("Символ '%c' отрисован в позиции (%d, %d) со стилем '%s'%n", symbol, x, y, style);
    }
}
