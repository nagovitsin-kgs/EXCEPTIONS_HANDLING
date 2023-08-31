package Seminar_2;

/** 
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив 
 * (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти 
 * по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
 * Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NameLength {
    public static List<String[]> readFile(String path) {
        List<String[]> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] tmp = line.split("=");
                if (!tmp[1].equals("?") && !isNumeric(tmp[1]))
                    throw new RuntimeException("После равно не знак вопроса и не число:" + line);
                list.add(tmp);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static boolean isNumeric(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void changeData(List<String[]> array) {
        for (String[] item : array) {
            if (Objects.equals(item[1], "?"))
                item[1] = String.valueOf(item[0].length());
        }
    }

    public static void writeFile(List<String[]> array, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (String[] item : array) {

                bw.write(item[0] + "=" + item[1]);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\user\\EXCEPTIONS_HANDLING\\src\\Seminar_2\\n" + //
                "ame.txt";
        String path1 = "C:\\Users\\user\\EXCEPTIONS_HANDLING\\src\\Seminar_2\\n" + //
                "ame2.txt";
        List<String[]> list = readFile(path);
        changeData(list);
        writeFile(list, path1);
    }
}