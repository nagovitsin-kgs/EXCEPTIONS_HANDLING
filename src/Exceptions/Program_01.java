package Exceptions;

// Введение в обработку исключений
/**
 * Нередко в процессе выполнения программы могут возникать ошибки, при том
 * необязательно по вине разработчика. Некоторые из них трудно предусмотреть или
 * предвидеть, а иногда и вовсе невозможно. Так, например, может неожиданно
 * оборваться сетевое подключение при передаче файла. Подобные ситуации
 * называются исключениями.
 * 
 * В языке Java предусмотрены специальные средства для обработки подобных
 * ситуаций. Одним из таких средств является конструкция try...catch...finally.
 * При возникновении исключения в блоке try управление переходит в блок catch,
 * который может обработать данное исключение. Если такого блока не найдено, то
 * пользователю отображается сообщение о необработанном исключении, а дальнейшее
 * выполнение программы останавливается. И чтобы подобной остановки не
 * произошло, и надо использовать блок try..catch. Например:
 * 
 * int[] numbers = new int[3];
 * numbers[4] = 45;
 * System.out.println(numbers[4]);
 * 
 * Так как у нас массив numbers может содержать только 3 элемента, то при
 * выполнении инструкции numbers[4]=45 консоль отобразит исключение, и
 * выполнение программы будет завершено. Теперь попробуем обработать это
 * исключение:
 * 
 * try {
 * int[] numbers = new int[3];
 * numbers[4] = 45;
 * System.out.println(numbers[4]);
 * } catch (Exception ex) {
 * 
 * ex.printStackTrace();
 * }
 * System.out.println("Программа завершена");
 * 
 * При использовании блока try...catch вначале выполняются все инструкции между
 * операторами try и catch. Если в блоке try вдруг возникает исключение, то
 * обычный порядок выполнения останавливается и переходит к инструкции сatch.
 * Поэтому когда выполнение программы дойдет до строки numbers[4]=45;, программа
 * остановится и перейдет к блоку catch
 * 
 * Выражение catch имеет следующий синтаксис: catch (тип_исключения
 * имя_переменной). В данном случае объявляется переменная ex, которая имеет тип
 * Exception. Но если возникшее исключение не является исключением типа,
 * указанного в инструкции сatch, то оно не обрабатывается, а программа просто
 * зависает или выбрасывает сообщение об ошибке.
 * 
 * Но так как тип Exception является базовым классом для всех исключений, то
 * выражение catch (Exception ex) будет обрабатывать практически все исключения.
 * Обработка же исключения в данном случае сводится к выводу на консоль стека
 * трассировки ошибки с помощью метода printStackTrace(), определенного в классе
 * Exception.
 * 
 * После завершения выполнения блока catch программа продолжает свою работу,
 * выполняя все остальные инструкции после блока catch.
 * 
 * Конструкция try..catch также может иметь блок finally. Однако этот блок
 * необязательный, и его можно при обработке исключений опускать. Блок finally
 * выполняется в любом случае, возникло ли исключение в блоке try или нет:
 */

public class Program_01 {
    public static void main(String[] args) {
        try {
            int[] numbers = new int[3];
            numbers[4] = 45; // здесь возникнит исключение
            System.out.println(numbers[4]);
        } catch (Exception ex) { // здесь исключение обработается

            ex.printStackTrace(); // здесь исключение выведеться на консоль
        } finally { // здесь в любом случае выполниться команды
            System.out.println("Блок finally");
        }
        System.out.println("Программа завершена"); // здесь выведиться после обработки catch
    }
}
