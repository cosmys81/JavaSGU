package org.knit.solutions.Tasks2Semestr;

import org.knit.solutions.Solution;
import org.knit.TaskDescription;
import org.knit.solutions.lab5.task15.Image;
import org.knit.solutions.lab5.task15.ImageProxy;

/**
 * Задача 15: Паттерн Прокси (Proxy) для удалённой библиотеки изображений
 * <p>
 * Описание:
 * - При запросе изображения оно загружается с сервера (симулируется задержкой).
 * - Изображение представляется классом RealImage.
 * - Прокси-объект ImageProxy лениво загружает изображение и кэширует его.
 * <p>
 * Требования:
 * - Реализовать класс RealImage для представления реального изображения.
 * - Реализовать класс ImageProxy для отложенной загрузки и кеширования.
 * - При повторном запросе загруженное изображение должно использоваться из кеша.
 */


@TaskDescription(taskNumber = 15,
        taskDescription = "Паттерн Прокси (Proxy)",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_15 implements Solution {

    @Override
    public void execute() {
        Image proxyImage1 = new ImageProxy("image1.png");
        Image proxyImage2 = new ImageProxy("image2.jpg");

        System.out.println("Первый вызов отображения image1:");
        proxyImage1.display();  // Загрузка и отображение с задержкой

        System.out.println("\nВторой вызов отображения image1:");
        proxyImage1.display();  // Мгновенное отображение из кеша

        System.out.println("\nОтображение image2:");
        proxyImage2.display();  // Загрузка и отображение с задержкой
        proxyImage2.display();  // Мгновенное отображение из кеша
    }
}
