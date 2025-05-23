package org.knit.solutions.lab5.task15;

/**
 * Прокси для изображения, обеспечивающий отложенную загрузку и кэширование.
 */
public class ImageProxy implements Image {
    private RealImage realImage;
    private final String filePath;

    public ImageProxy(String filePath) {
        this.filePath = filePath;
    }

    private void loadImage() {
        System.out.println("Загрузка изображения (прокси) для файла: " + filePath);
        try {
            Thread.sleep(3000); // Симуляция долгой загрузки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        realImage = new RealImage(filePath);
    }

    @Override
    public void display() {
        if (realImage == null) {
            loadImage();
        } else {
            System.out.println("Изображение уже загружено: " + filePath);
        }
        realImage.display();
    }
}
