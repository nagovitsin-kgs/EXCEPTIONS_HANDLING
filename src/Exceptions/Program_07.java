package Exceptions;

// Создание своих классов исключений
/**
 * Хотя имеющиеся в стандартной библиотеке классов Java классы исключений
 * описывают большинство исключительных ситуаций, которые могут возникнуть при
 * выполнении программы, все таки иногда требуется создать свои собственные
 * классы исключений со своей логикой.
 * 
 * Чтобы создать свой класс исключений, надо унаследовать его от класса
 * Exception. Например, у нас есть класс, вычисляющий факториал, и нам надо
 * выбрасывать специальное исключение, если число, передаваемое в метод, меньше
 * 1:
 * 
 * Здесь для определения ошибки, связанной с вычислением факториала, определен
 * класс FactorialException, который наследуется от Exception и который содержит
 * всю информацию о вычислении. В конструкторе FactorialException в конструктор
 * базового класса Exception передается сообщение об ошибке: super(message).
 * Кроме того, отдельное поле предназначено для хранения числа, факториал
 * которого вычисляется.
 * 
 * Для генерации исключения в методе вычисления факториала выбрасывается
 * исключение с помощью оператора throw: throw new FactorialException("Число не
 * может быть меньше 1", num). Кроме того, так как это исключение не
 * обрабатывается с помощью try..catch, то мы передаем обработку вызывающему
 * методу, используя оператор throws: public static int getFactorial(int num)
 * throws FactorialException
 * 
 * Теперь используем класс в методе main:
 */

public class Program_07 {
    public static void main(String[] args) {

        try {
            int result = Factorial.getFactorial(6);
            System.out.println(result);
        } catch (FactorialException ex) {

            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }
    }

}

class Factorial {

    public static int getFactorial(int num) throws FactorialException {

        int result = 1;
        if (num < 1)
            throw new FactorialException("Это число меньше 1", num);

        for (int i = 1; i <= num; i++) {

            result *= i;
        }
        return result;
    }
}

class FactorialException extends Exception {

    private int number;

    public int getNumber() {
        return number;
    }

    public FactorialException(String message, int num) {

        super(message);
        number = num;
    }
}