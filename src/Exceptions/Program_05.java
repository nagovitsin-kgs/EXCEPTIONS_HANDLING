package Exceptions;

// Оператор throws
/**
 * Продолжение из Program_04
 * 
 * Без обработки исключение у нас возникнет ошибка компиляции, и мы не сможем
 * скомпилировать программу.
 * 
 * В качестве альтернативы мы могли бы и не использовать оператор throws, а
 * обработать исключение прямо в методе:
 */
public class Program_05 {
    public static void main(String[] args) {
        int result = getFactorial(-6);
        System.out.println(result);
    }

    public static int getFactorial(int num) {
        int result = 1;
        try {
            if (num <= 1)
                throw new Exception("Это число меньше 1");

            for (int i = 1; i <= num; i++) {
                result *= i;
            }
        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println(ex.getMessage());
            result = num;
        }
        return result;
    }
}
