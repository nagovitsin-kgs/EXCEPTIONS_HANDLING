package Exceptions;

// Классы исключений
/**
 * Базовым классом для всех исключений является класс Throwable. От него уже
 * наследуются два класса: Error и Exception. Все остальные классы являются
 * производными от этих двух классов.
 * 
 * Класс Error описывает внутренние ошибки в исполняющей среде Java. Программист
 * имеет очень ограниченные возможности для обработки подобных ошибок.
 * 
 * Собственно исключения наследуются от класса Exception. Среди этих исключений
 * следует выделить класс RuntimeException. RuntimeException является базовым
 * классом для так называемой группы непроверяемых исключений (unchecked
 * exceptions) - компилятор не проверяет факт обработки таких исключений и их
 * можно не указывать вместе с оператором throws в объявлении метода. Такие
 * исключения являются следствием ошибок разработчика, например, неверное
 * преобразование типов или выход за пределы массива.
 * 
 * Некоторые из классов непроверяемых исключений:
 * 
 * ArithmeticException: исключение, возникающее при делении на ноль
 * 
 * IndexOutOfBoundException: индекс вне границ массива
 * 
 * IllegalArgumentException: использование неверного аргумента при вызове метода
 * 
 * NullPointerException: использование пустой ссылки
 * 
 * NumberFormatException: ошибка преобразования строки в число
 * 
 * Все остальные классы, образованные от класса Exception, называются
 * проверяемыми исключениями (checked exceptions).
 * 
 * Некоторые из классов проверяемых исключений:
 * 
 * CloneNotSupportedException: класс, для объекта которого вызывается
 * клонирование, не реализует интерфейс Cloneable
 * 
 * InterruptedException: поток прерван другим потоком
 * 
 * ClassNotFoundException: невозможно найти класс
 * 
 * Подобные исключения обрабатываются с помощью конструкции try..catch. Либо
 * можно передать обработку методу, который будет вызывать данный метод, указав
 * исключения после оператора throws:
 * public Person clone() throws CloneNotSupportedException{
 * 
 * Person p = (Person) super.clone();
 * return p;
 * }
 * В итоге получается следующая иерархия исключений: см.
 * Hierarchy_Exclusions.png
 * 
 * Поскольку все классы исключений наследуются от класса Exception, то все они
 * наследуют ряд его методов, которые позволяют получить информацию о характере
 * исключения. Среди этих методов отметим наиболее важные:
 * 
 * Метод getMessage() возвращает сообщение об исключении
 * 
 * Метод getStackTrace() возвращает массив, содержащий трассировку стека
 * исключения
 * 
 * Метод printStackTrace() отображает трассировку стека
 * 
 * Например:
 * 
 * try{
 * int x = 6/0;
 * }
 * catch(Exception ex){
 * 
 * ex.printStackTrace();
 * }
 */
public class Program_06 {
    public static void main(String[] args) {
        Person p = new Person("Лёша", 39);
        System.out.println(p);
        Exception(); // java.lang.ArithmeticException: / by zero

    }

    public static void Exception() {
        try {
            int x = 6 / 0; // сработает исключение и выведет в catch
            System.out.println(x);

        } catch (Exception ex) {

            ex.printStackTrace(); // // java.lang.ArithmeticException: / by zero
        }

    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person getClone() throws CloneNotSupportedException {

        Person p = (Person) super.clone();
        return p;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}
