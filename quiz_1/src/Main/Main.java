package Main;

import java.util.Random;
import java.util.Scanner;

public class Main {
//            TASK 3
    protected static boolean primeOrNot(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int task3(int a, int b) {
        int res=0, rand;
        if (a > b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            rand = r.nextInt(a, b);
            System.out.println(String.valueOf(rand));
            if (primeOrNot(rand)) {res += 1;}
        }
        System.out.println("number of primes:");
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        System.out.println(task3(x, y));
    }
}
