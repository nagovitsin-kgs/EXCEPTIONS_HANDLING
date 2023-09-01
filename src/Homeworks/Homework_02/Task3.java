package Homeworks.Homework_02;

// Урок 2. Исключения и их обработка
/**
 * Задача 3:
 * Дан следующий код, исправьте его там, где требуется (задание 3
 * https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 * 
 * public static void main(String[] args) throws Exception {
 * try {
 * int a = 90;
 * int b = 3;
 * System.out.println(a / b);
 * printSum(23, 234);
 * int[] abc = { 1, 2 };
 * abc[3] = 9;
 * } catch (Throwable ex) {
 * System.out.println("Что-то пошло не так...");
 * } catch (NullPointerException ex) {
 * System.out.println("Указатель не может указывать на null!");
 * } catch (IndexOutOfBoundsException ex) {
 * System.out.println("Массив выходит за пределы своего размера!");
 * }
 * }
 * public static void printSum(Integer a, Integer b) throws
 * FileNotFoundException {
 * System.out.println(a + b);
 * }
 * 
 */

public class Task3 {
    public static void main(String[] args) {
        /**
         * В данном коде имеется несколько проблем, которые надо испрвить.
         * 
         * 1. В блоке try содержиться несколько строк кода, которые потенциально могут
         * вызвать исключение. При возникновение исключения в одной из этих строк,
         * выполнение кода в блоке try прекращается, и упрвление предаёться в
         * соответствующий блок catch. В данном случае, если в строке abc[3] = 9;
         * возникнет исключение IndexOutOfBoundsException, то следующаяя строка
         * System.out.println("Что-то пошло не так..."); никогда не будет выполнена. Для
         * исправления данной проблемы необходимо разделять код, вызывающий потенциально
         * опасные действия, на отдельные блоки try-catch.
         * 
         * 2. В методе printSum объявлено исключение FileNotFoundException, но нигде в
         * коде данного метода оно не используется. Для исправления данной проблемы
         * следует удалить объявление данного исклюячения из сигнатуры метода.
         * 
         * Исправленный код:
         */
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        }

        try {
            printSum(23, 234);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        }

        try {
            int[] abc = new int[2];
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
    /**
     * В данном исправленном коде произведены следующие изменения:
     * 
     * 1. Вместо объединения всех потенциально опасных действий в один блок
     * try-catch, каждое действие помещено в свой отдельный блок try-catch. Теперь,
     * если в одном блоке возникнет исключение, оно будет обработано только в этом
     * блоке, и выполнение кода будет продолжено сразу за ним.
     * 
     * 2. Удалено объявление исключения FileNotFoundException из сигнатуры метода
     * printSum, так как данное исключение нигде в коде метода не используется.
     */

}