package org.knit.solutions.Task20;

import org.knit.solutions.Task20.passwordmanager.config.AppConfig;
import org.knit.solutions.Task20.passwordmanager.model.PasswordEntry;
import org.knit.solutions.Task20.passwordmanager.security.MasterPasswordHolder;
import org.knit.solutions.Task20.passwordmanager.service.PasswordService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        PasswordService manager = ctx.getBean(PasswordService.class);
        MasterPasswordHolder masterKey = ctx.getBean(MasterPasswordHolder.class);

        char[] password;
        System.out.print("Мастер-пароль: ");
        Scanner sc = new Scanner(System.in);
        if (System.console() != null) {
            password = System.console().readPassword();
        } else {
            password = sc.nextLine().toCharArray();
        }
        masterKey.set(password);

        Runtime.getRuntime().addShutdownHook(new Thread(masterKey::clear));

        while (true) {
            System.out.print("> ");
            String[] input = sc.nextLine().trim().split("\\s+", 2);
            String cmd = input[0];

            switch (cmd) {
                case "add" -> {
                    System.out.print("Сайт: ");
                    String s = sc.nextLine();
                    System.out.print("Логин: ");
                    String u = sc.nextLine();
                    System.out.print("Пароль: ");
                    String p = sc.nextLine();
                    manager.add(s, u, p);
                    System.out.println("Сохранено.");
                }
                case "list" -> {
                    List<PasswordEntry> all = manager.list();
                    if (all.isEmpty()) {
                        System.out.println("Пусто.");
                    } else {
                        all.forEach(e -> System.out.println(e.getSite() + " | " + e.getUsername()));
                    }
                }
                case "copy" -> {
                    if (input.length < 2) {
                        System.out.println("Нужно указать сайт.");
                        break;
                    }
                    boolean copied = manager.copy(input[1]);
                    System.out.println(copied ? "Скопировано!" : "Сайт не найден.");
                }
                case "delete" -> {
                    if (input.length < 2) {
                        System.out.println("Укажите сайт.");
                        break;
                    }
                    manager.delete(input[1]);
                    System.out.println("Удалено.");
                }
                case "exit" -> {
                    System.out.println("Завершение...");
                    ctx.close();
                    return;
                }
                default -> System.out.println("Неизвестная команда.");
            }
        }
    }
}
