package org.knit.solutions.lab5.task15;

/**
 * Реальный класс изображения, который загружает и отображает картинку.
 */
class RealImage implements Image {
    private final String filePath;

    public RealImage(String filePath) {
        this.filePath = filePath;
        System.out.println("Создан объект RealImage для файла: " + filePath);
    }

    @Override
    public void display() {
        System.out.println("Отображение изображения: " + filePath);
    }
}
