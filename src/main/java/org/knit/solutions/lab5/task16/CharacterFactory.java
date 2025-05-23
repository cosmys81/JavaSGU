package org.knit.solutions.lab5.task16;

import java.util.HashMap;
import java.util.Map;

/**
 * Фабрика для создания и повторного использования объектов TextCharacter (приспособленцев).
 */
public class CharacterFactory {
    private static final Map<Character, TextCharacter> characterCache = new HashMap<>();

    public static TextCharacter getCharacter(char symbol) {
        characterCache.putIfAbsent(symbol, new TextCharacter(symbol));
        return characterCache.get(symbol);
    }
}
