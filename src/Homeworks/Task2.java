package Homeworks;

import java.util.Arrays;

// Разность двух массивов
/**
 * Реализуйте метод subArrays, принимающий в качестве аргументов два
 * целочисленных массива a и b, и возвращающий новый массив c, каждый элемент
 * которого равен разности элементов двух входящих массивов в той же ячейке.
 * 
 * Если длины массивов не равны - верните нулевой массив длины 1.
 * 
 * Напишите свой код в методе subArrays класса Answer. Метод subArrays принимает
 * на вход два параметра:
 * 
 * int[] a - первый массив
 * int[] b - второй массив
 * Пример
 * 
 * 
 * a = new int[]{4, 5, 6};
 * b = new int[]{1, 2, 3};
 * 
 * Вывод: [3, 3, 3]
 * 
 * a = new int[]{4, 5, 6};
 * b = new int[]{1, 2, 3, 5};
 * 
 * Вывод: [0]
 * 
 * Копирование доступно только PRO пользователям, получить PRO статус можно по
 * этой ссылке: https://чатгпт-в-россии.рф/страница-покупки-pro-статуса
 */

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Task2 {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[] { 4, 5, 6 };
            b = new int[] { 1, 2, 3 };
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        Answer ans = new Answer();
        String itresume_res = Arrays.toString(ans.subArrays(a, b));
        System.out.println(itresume_res);

    }

}

class Answer {
    public int[] subArrays(int[] a, int[] b) {
        // Введите свое решение ниже

        // Проверяем равны ли длины массивов a и b
        if (a.length != b.length) {
            // Если не равны, создаём и возвращаем новый массив c длины 1, содержащий только
            // значение 0
            int[] c = new int[] { 0 };
            return c;
        }
        // Создаём новый массив c длины, равной длине массива a или b
        int[] c = new int[a.length];
        // Проходим по каждой ячейке массивов a и b, вычисляя разность их элементов и
        // сохраняя эту разность в массиве c
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }
        // Возвращаем массив c
        return c;
    }
}
