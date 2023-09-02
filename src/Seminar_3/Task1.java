package Seminar_3;

/**
 * Создайте метод doSomething(), который может быть источником одного из типов
 * checked exceptions (тело самого метода прописывать не обязательно). Вызовите
 * этот метод из main и обработайте в нем исключение, которое вызвал метод
 * doSomething().
 */
public class Task1 {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println("Обработка исключения: " + e.getMessage());
        }
    }

    public static void doSomething() throws Exception {

        // Тело метода, вызывающего checked исключение
    }
}
