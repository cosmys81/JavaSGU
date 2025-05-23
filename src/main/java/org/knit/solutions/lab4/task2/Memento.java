package org.knit.solutions.lab4.task2;

/**
 * Снимок состояния текстового редактора.
 * Сохраняет копию текста.
 */
class Memento {
    private final String content;

    public Memento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
