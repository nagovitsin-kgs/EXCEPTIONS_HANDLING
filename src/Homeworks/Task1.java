package Homeworks;

class Task1 {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}

class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] numbers = new int[3];
        numbers[4] = 45; // здесь возникнит исключение
        System.out.println(numbers[2]);
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int x = 6 / 0; // сработает исключение и выведет в catch
        System.out.println(x);

    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        int[] numbers = new int[10];
        numbers[7] = Integer.parseInt("Лёша");
        System.out.println(numbers[7]);

    }

}
