package org.knit.solutions.Tasks2Semestr;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.knit.solutions.lab5.task14.*;

/**
 * Задача 17: Реализация и проверка парадокса Монти Холла
 * <p>
 * Описание:
 * - Участник выбирает одну из трёх дверей.
 * - Ведущий открывает одну из оставшихся дверей, за которой нет приза.
 * - Участник может либо сменить выбор, либо оставить его неизменным.
 * <p>
 * Требования:
 * - Реализовать симуляцию игры на Java.
 * - Провести большое количество экспериментов (например, 1 000 000).
 * - Подсчитать вероятность выигрыша в каждом из двух случаев.
 * <p>
 * Ожидаемый результат:
 * - Вероятность выигрыша при смене выбора ≈ 66.66% (2/3).
 * - Вероятность выигрыша без смены ≈ 33.33% (1/3).
 */


@TaskDescription(taskNumber = 14,
        taskDescription = "Паттерн Визитер (Visitor)",
        href = "org/knit/solutions/taskExampleClasses/README.md")
public class Task2_14 implements Solution {

    @Override
    public void execute() {
        File fileA = new File("file1.txt", 500, false);
        File fileB = new File("file2.exe", 1000, true);
        File fileC = new File("file3.jpg", 750, false);

        Folder docsFolder = new Folder("Documents");
        docsFolder.addElement(fileA);
        docsFolder.addElement(fileB);
        docsFolder.addElement(fileC);

        Shortcut shortcutToFileA = new Shortcut(fileA);

        Folder rootFolder = new Folder("Root");
        rootFolder.addElement(docsFolder);
        rootFolder.addElement(shortcutToFileA);

        System.out.println("Запуск сканера вирусов:");
        VirusScanner scanner = new VirusScanner();
        rootFolder.accept(scanner);

        System.out.println("\nПодсчёт общего размера файлов:");
        SizeAnalyzer analyzer = new SizeAnalyzer();
        rootFolder.accept(analyzer);
        System.out.println("Общий размер: " + analyzer.getTotalSize() + " байт");
    }
}