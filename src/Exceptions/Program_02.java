package Exceptions;

// Обработка нескольких исключений
/**
 * В Java имеется множество различных типов исключений, и мы можем разграничить
 * их обработку, включив дополнительные блоки catch.
 * 
 * Если у нас возникает исключение определенного типа, то оно переходит к
 * соответствующему блоку catch:
 */

public class Program_02 {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        try {
            numbers[4] = 45; // Здесь сработает 1 catch
            numbers[7] = Integer.parseInt("gfd"); // Здесь сработает 2 catch, если выше всё правильно
        } catch (ArrayIndexOutOfBoundsException ex) {

            System.out.println("Выход за пределы массива");

        } catch (NumberFormatException ex) {

            System.out.println("Ошибка преобразования из строки в число");
        }
    }
}
