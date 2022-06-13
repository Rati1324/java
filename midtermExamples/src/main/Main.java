package main;
import thread.Thread1;
import thread.Thread2;

import java.util.Arrays;

public class Main {
    public static boolean palindrome(int x) {
        int temp = x;
        int n = 0;
        while (x > 0) {
            n = n * 10 + (x % 10);
            x /= 10;
        }
        return temp == x;
    }
    public static void sortArray(int[][] x) {
        int temp;
        for (int k = 0; k < x.length - 1; k++) {
            for (int i = 0; i < x.length - k - 1; i++) {
                if (x[i][0] < x[i + 1][0]) {
                    for (int j = 0; j < x[i].length; j++) {
                        temp = x[i][j];
                        x[i][j] = x[i + 1][j];
                        x[i + 1][j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Thread1 t = new Thread1();
        Thread2 t2 = new Thread2();
        t.setPriority(1);
        t2.setPriority(5);
        t.start();
        t2.start();
    }
}
