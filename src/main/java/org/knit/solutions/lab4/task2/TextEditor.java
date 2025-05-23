package org.knit.solutions.lab4.task2;

/**
 * Текстовый редактор, умеет создавать снимки своего состояния и восстанавливаться из них.
 */
public class TextEditor {
    private String content;

    public TextEditor(String initialText) {
        this.content = initialText;
    }

    public Memento createSnapshot() {
        return new Memento(content);
    }

    public void restore(Memento snapshot) {
        this.content = snapshot.getContent();
        System.out.println("Восстановленный текст: " + content);
    }
}
