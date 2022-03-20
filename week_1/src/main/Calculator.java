package main;

import java.util.Scanner;

public class Calculator {
    public static int calculator() {
        int x, y, res = 0;
        char op;

        Scanner s = new Scanner(System.in);
        String calc = s.nextLine();
        x = Integer.parseInt(String.valueOf(calc.charAt(0)));
        y = Integer.parseInt(String.valueOf(calc.charAt(2)));
        op = calc.charAt(1);

        switch (op) {
            case '+':
                res = x + y;
                break;
            case '-':
                res = x - y;
                break;
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(calculator());
    }
}
