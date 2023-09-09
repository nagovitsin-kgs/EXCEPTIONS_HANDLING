package Tasks_test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Исключения в программировании и их обработка (семинары)
// Урок 3. Продвинутая работа с исключениями в Java
/**
 * ДЗ_03: Промежуточная аттестация.
 * 
 * Напишите приложение, которое будет запрашивать у пользователя следующие
 * данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 * 
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * датарождения - строка формата dd.mm.yyyy
 * номертелефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * 
 * Приложение должно проверить введенные данные по количеству. Если количество
 * не совпадает с требуемым, вернуть код ошибки, обработать его и показать
 * пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * 
 * Приложение должно попытаться распарсить полученные значения и выделить из них
 * требуемые параметры. Если форматы данных не совпадают, нужно бросить
 * исключение, соответствующее типу проблемы. Можно использовать встроенные типы
 * java и создать свои. Исключение должно быть корректно обработано,
 * пользователю выведено сообщение с информацией, что именно неверно.
 * 
 * Если всё введено и обработано верно, должен создаться файл с названием,
 * равным фамилии, в него в одну строку должны записаться полученные данные,
 * вида
 * 
 * <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 * 
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * 
 * Не забудьте закрыть соединение с файлом.
 * 
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть
 * корректно обработано, пользователь должен увидеть стектрейс ошибки.
 * 
 * Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"
 * 
 * "Зачет" ставится, если слушатель успешно выполнил
 * "Незачет"" ставится, если слушатель успешно выполнил
 * 
 * Критерии оценивания:
 * Слушатель напишите приложение, которое будет запрашивать у пользователя
 * следующие данные в произвольном порядке, разделенные пробелами.
 */

public class Program_test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Создаём Map для хранения данных однофамильцев
        Map<String, String> data = new HashMap<>();

        while (true) {

            System.out.println("Введите данные (Фамилия Имя Отчество дата рождения номер_телефона пол):");
            String input = scanner.nextLine();

            // Проверяем, является ли введённая строка пустой
            if (input.isEmpty()) {
                break;
            }

            // Разделяем введённые данные по пробелу
            String[] parts = input.split(" ");

            // Проверяем количество введённых данных
            if (parts.length != 6) {
                System.out.println("Ошибка ввода данных. Попробуйте ещё раз.");
                continue;
            }

            String lastName = parts[0];
            String firstName = parts[1];
            String patronymic = parts[2];
            String dateOfBirth = parts[3];
            String phoneNumber = parts[4];
            String gender = parts[5];

            // Проверяем форматы данных
            if (!isValidDate(dateOfBirth) || !isValidPhoneNumber(phoneNumber) ||
                    !isValidGender(gender)) {
                System.out.println("Ошибка ввода данных. Попробуйте ещё раз.");
                continue;
            }

            // Форматируем строку для записи в файл
            String dataString = lastName + " " + firstName + " " + patronymic + " " +
                    dateOfBirth + " " + phoneNumber
                    + " " + gender + " ";

            // Записываем данные в файл
            try {
                // Открываем файл на дозапись
                BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true));
                writer.write(dataString);
                writer.newLine();
                writer.close();

            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл.");
                e.printStackTrace();
            }

            // Добавляем данные в Map для однофамильцев
            data.put(lastName, dataString);
        }

        // Выводим данные однофамильцев
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Закрываем соединение с пользовательским вводом
        scanner.close();
    }

    // Проверка формата даты (dd.mm.yyyy)
    private static boolean isValidDate(String date) {
        String regex = "dd.MM.yyyy"; // "\d{2}\.\d{2}\.\d{4}";
        return date.matches(regex);
    }

    // Проверка формата номера телефона (целое беззнаковое число без форматирования)
    private static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "\f+";
        return phoneNumber.matches(regex);
    }

    // Проверка формата пола (f или m)
    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }

}
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.Scanner;

// public class Main {
// public static void main(String[] args) {
// Scanner scanner = new Scanner(System.in);
// System.out.println("Введите данные (Фамилия Имя Отчество дата рождения
// номер_телефона пол):");
// String input = scanner.nextLine();
// try {
// String[] data = input.split(" ");
// if (data.length != 5) {
// throw new IllegalArgumentException("Количество данных не соответствует
// требуемому.");
// }
// String lastName = data[0];
// String firstName = data[1];
// String middleName = data[2];
// Date dateOfBirth = parseDate(data[3]);
// int phoneNumber = Integer.parseInt(data[4]);
// char gender = data[5].charAt(0);
// // Вывод обработанных данных
// System.out.println("Фамилия: " + lastName);
// System.out.println("Имя: " + firstName);
// System.out.println("Отчество: " + middleName);
// System.out.println("Дата рождения: " + formatDate(dateOfBirth));
// System.out.println("Номер телефона: " + phoneNumber);
// System.out.println("Пол: " + gender);
// } catch (IllegalArgumentException e) {
// System.out.println("Ошибка: " + e.getMessage());
// } catch (ParseException e) {
// System.out.println("Ошибка: Неверный формат даты");
// } catch (NumberFormatException e) {
// System.out.println("Ошибка: Неверный формат номера телефона.");
// } catch (ArrayIndexOutOfBoundsException e) {
// System.out.println("Ошибка: Недостаточно данных");
// }
// }

// private static Date parseDate(String dateStr) throws ParseException {
// SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
// return format.parse(dateStr);
// }

// private static String formatDate(Date date) {
// SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
// return format.format(date);
// }
// }

// import java.io.*;
// import java.nio.file.FileSystemException;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// public class Main_03 {
// public static void main(String[] args) throws IOException {
// // Напишите приложение, которое будет запрашивать у пользователя следующие
// // данные в произвольном порядке, разделенные пробелом:
// // Фамилия Имя Отчество датарождения номертелефона пол
// // Форматы данных:
// // фамилия, имя, отчество - строки
// //
// // дата_рождения - строка формата dd.mm.yyyy
// //
// // номер_телефона - целое беззнаковое число без форматирования
// //
// // пол - символ латиницей f или m.
// //
// // Приложение должно проверить введенные данные по количеству. Если
// количество
// // не совпадает с требуемым, вернуть код ошибки, обработать его и показать
// // пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
// //
// // Приложение должно попытаться распарсить полученные значения и выделить из
// них
// // требуемые параметры. Если форматы данных не совпадают, нужно бросить
// // исключение, соответствующее типу проблемы. Можно использовать встроенные
// типы
// // java и создать свои. Исключение должно быть корректно обработано,
// // пользователю выведено сообщение с информацией, что именно неверно.
// //
// // Если всё введено и обработано верно, должен создаться файл с названием,
// // равным фамилии, в него в одну строку должны записаться полученные данные,
// // вида
// //
// // <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// //
// // Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// //
// // Не забудьте закрыть соединение с файлом.
// //
// // При возникновении проблемы с чтением-записью в файл, исключение должно
// быть
// // корректно обработано, пользователь должен увидеть стектрейс ошибки.

// try {
// makeRecord();
// System.out.println("success");
// } catch (FileSystemException e) {
// System.out.println(e.getMessage());
// } catch (Exception e) {
// System.out.println(e.getStackTrace());
// }

// }

// public static void makeRecord() throws Exception {
// System.out.println(
// "Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер
// телефона (число без разделителей) и пол(символ латиницей f или m),
// разделенные пробелом");

// String text;
// try (BufferedReader bf = new BufferedReader(new
// InputStreamReader(System.in))) {
// text = bf.readLine();
// } catch (IOException e) {
// throw new Exception("Произошла ошибка при работе с консолью");
// }

// String[] array = text.split(" ");
// if (array.length != 6) {
// throw new Exception("Введено неверное количество параметров");
// }

// String surname = array[0];
// String name = array[1];
// String patronymic = array[2];

// SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
// Date birthdate;
// try {
// birthdate = format.parse(array[3]);
// } catch (ParseException e) {
// throw new ParseException("Неверный формат даты рождения",
// e.getErrorOffset());
// }

// int phone;
// try {
// phone = Integer.parseInt(array[4]);
// } catch (NumberFormatException e) {
// throw new NumberFormatException("Неверный формат телефона");
// }

// String sex = array[5];
// if (!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("f")) {
// throw new RuntimeException("Неверно введен пол");
// }

// String fileName = "files\\" + surname.toLowerCase() + ".txt";
// File file = new File(fileName);
// try (FileWriter fileWriter = new FileWriter(file, true)) {
// if (file.length() > 0) {
// fileWriter.write('\n');
// }
// fileWriter.write(String.format("%s %s %s %s %s %s", surname, name,
// patronymic, format.format(birthdate),
// phone, sex));
// } catch (IOException e) {
// throw new FileSystemException("Возникла ошибка при работе с файлом");
// }

// }
// }