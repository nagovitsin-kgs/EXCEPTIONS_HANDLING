package Seminar_3;

import java.io.IOException;

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 * внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 * можно было работать в блоке try-with-resources. Подумайте, что должно
 * происходить при закрытии этого ресурса? Напишите метод для проверки, закрыт
 * ли ресурс. При попытке вызвать add() у закрытого ресурса, должен выброситься
 * IOException
 * 
 * 
 */

public class Task2_Counter implements AutoCloseable {
    private int value;

    public Task2_Counter() {
        value = 0;
    }

    public void add() throws IOException {
        if (isClosed()) {
            throw new IOException("Ресурс закрыт");
        }
        value++;
    }

    public boolean isClosed() {
        // Реализация метода проверки, закрыт ли ресурс
        //
        // Например, можно добавить в класс поле сlosed типа boolean, которое будет
        // менять значение при вызове метода сlose() и проверять его значение в методе
        // add()

        return false;
    }

    @Override
    public void close() {
        // Реализация метода, вызывающего при закрытии ресурса
        //
        // Например, в этом методе можно установить close = true
    }

}

// import java.io.IOException;

// public class CountTask2 implements AutoCloseable
// {
// private Integer count;

// public CountTask2() {
// this.count = 0;
// }

// public Integer getCount() throws IOException {
// checkClose();
// return count;
// }

// public void add() throws IOException {
// checkClose();
// this.count++;
// }
// public void checkClose() throws IOException {
// if (this.count == null)
// throw new IOException("Экземпляр закрыт");
// }
// @Override
// public void close() {
// this.count = null;
// }
// }