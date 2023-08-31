package Homeworks;

import java.util.Arrays;

class Answer {
    public int[] subArrays(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return new int[1]; // нулевой массив длины 1 будет означать различие в длине массивов
        } else {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] - b[i];
            }
            return c;
        }
    }
}

public class Task2_1 {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            a = new int[] { 4, 5, 6 };
            b = new int[] { 1, 2, 3 };
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        Answer ans = new Answer();
        String itresume_res = Arrays.toString(ans.subArrays(a, b));
        System.out.println(itresume_res);
    }
}
