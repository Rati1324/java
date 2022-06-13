package main;

import java.util.Random;
import java.util.Scanner;

public class A {
    protected int[] m = new int[15];

    public void M1() {
        int min, max;
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            System.out.println("Enter min:");
            min = s.nextInt();
            System.out.println("Enter max:");
            max = s.nextInt();
            m[i] = r.nextInt(min, max);
            System.out.println(m[i]);
        }
    }

    public int M2() {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] < i) {
                sum += m[i];
            }
        }
        return sum;
    }

    public int M3() {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > i) {
                sum += m[i];
            }
        }
        return sum;
    }

    public void M4() {
        for (int j : m) {
            if (j % 2 != 0) {
                System.out.println(j);
            }
        }
    }
}