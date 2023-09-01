package Homeworks.Homework_02;

import java.util.Scanner;

// Урок 2. Исключения и их обработка
/**
 * Задача 1:
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float), и возвращает введенное значение. Ввод текста вместо числа не
 * должно приводить к падению приложения, вместо этого, необходимо повторно
 * запросить у пользователя ввод данных.
 */

public class Task1 {
    public static void main(String[] args) {

        Answer answer = new Answer();
        float number = answer.getFloatingPointNamber();
        System.out.println("Вы ввели чило: " + number);

    }
}

class Answer {

    public float getFloatingPointNamber() {

        Scanner scanner = new Scanner(System.in);

        float number = 0f;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введите дробное число: ");
            if (scanner.hasNextFloat()) {
                number = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Ошибка ввода! Пожалуйста введите дробное число.");
                scanner.next(); // очистка вводного буфера
            }
        }
        scanner.close();
        return number;
    }
}
