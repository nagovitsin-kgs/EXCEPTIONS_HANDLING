package Homeworks.Homework_02;

// Урок 2. Исключения и их обработка
/**
 * Задача 2:
 * Если необходимо, исправьте данный код (задание 2
 * https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 */

public class Task2 {
    public static void main(String[] args) {
        /**
         * Данный код содержит ошибку и не скомпилируется, так как переменная intArray
         * не была объявлена и инициализирована. При условии, что intArray представляет
         * собой массив целых чисел, исправим код следующим образом:
         */
        try {
            int d = 0;
            int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
        /**
         * Теперь в коде объявлен и инициализирован массив intArray, который содержит 10
         * элементов (цклые числа от 1 до 10). В строке int d = 0; переменная d равна 0,
         * а затем в строке double catchedRes1 = intArray[8] / d; происходит деление
         * массива с индексом 8 на ноль. Так деление на ноль является арифметической
         * ошибкой, будет выброшено исключения типа ArithmeticException.
         * 
         * Затем в блоке catch (ArithmeticException e) выводиться сообщение "Catching
         * exception: " + e, где e - это сам объект исключения. Таким образом, если
         * произойдет деление на ноль, будет выведено сообщение Catching exception:
         * java.lang.ArithmeticException: / by zero.
         * 
         * Описание и исправление этой программы поможет избежать ошибки, в случае
         * деления на ноль и улучшит структуру кода.
         */

    }
}
