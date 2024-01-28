package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1. Проверка по возрасту");
        System.out.println("2. Вычисление периметра, площади и радиуса окружности");

        int choice = scanner.nextInt();

        if (choice == 1) {
            faceControl();  // Метод с маленькой буквы
        } else if (choice == 2) {
            Psr();
        } else {
            System.out.println("Некорректный выбор.");
        }

        scanner.close();
    }

    public static void faceControl() {
        FaceControl[] faceControlArray = new FaceControl[2];

        faceControlArray[0] = new FaceControl("Alice", 22, LocalDate.of(2000, 5, 15));
        faceControlArray[1] = new FaceControl("Bob", 17, LocalDate.of(2005, 8, 20));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуйте, вы попали на фейс-контроль.");
        System.out.print("Введите ваше име: ");

        String name = scanner.next();

        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();

        System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД: ");
        String birthDateString = scanner.next();
        LocalDate birthDate = LocalDate.parse(birthDateString);

        LocalDate currentDate = LocalDate.now();

        if (age < 18 || (age == 18 && birthDate.isBefore(LocalDate.of(2006, 1, 24)))) {
            System.out.println("Вход запрещен.");
        } else {
            System.out.println("Добро пожаловать на закрытое мероприятие!");
        }

        scanner.close();
    }

    public static void Psr() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите радиус окружности: ");
        double radius = scanner.nextDouble();

        double perimeter = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;

        System.out.println("Периметр окружности: " + perimeter);
        System.out.println("Площадь окружности: " + area);
        System.out.println("Радиус окружности: " + radius);

        scanner.close();
    }
}

class FaceControl {
    private String name;
    private int age;
    private LocalDate birthDate;

    public FaceControl(String name, int age, LocalDate birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }
}
