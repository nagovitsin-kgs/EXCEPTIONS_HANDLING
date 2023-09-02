package Seminar_3;

/**
 * 1. Создайте класс исключения, который будет выбрасываться при делении на 0.
 * Исключение должно отображать понятное для пользователя сообщение об ошибке.
 * 
 * 2. Создайте класс исключений, которое будет возникать при обращении к пустому
 * элементу в массиве ссылочного типа. Исключение должно отображать понятное для
 * пользователя сообщение об ошибке
 * 
 * 3. Создайте класс исключения, которое будет возникать при попытке открыть
 * несуществующий файл. Исключение должно отображать понятное для пользователя
 * сообщение об ошибке.
 */

public class Task3 {
    public static void main(String[] args) {

    }
}
// import java.io.FileNotFoundException;

// public class Task3 {
// }

// class DivBuZero extends ArithmeticException{
// public DivBuZero() {
// super("Деление на 0 запрещено ");
// }
// }

// class NullPointerArray extends NullPointerException{
// public NullPointerArray(int index) {
// super("Oбращении к пустому элементу в массиве запрещено,индекс элемента: " +
// index);
// }

// public NullPointerArray() {
// super("Oбращении к пустому элементу в массиве запрещено ");
// }
// }

// class NotFile extends FileNotFoundException{
// public NotFile(String path) {
// super("Открыть несуществующий файл нельзя, ваш путь к фалу -> " + path);
// }
// public NotFile() {
// super("Открыть несуществующий файл нельзя");
// }

// }