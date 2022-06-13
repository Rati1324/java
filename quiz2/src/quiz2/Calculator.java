package quiz2;

import java.util.Stack;
import java.util.regex.Pattern;

public class Calculator {
    public static boolean isNumeric(String n) {
        if (n == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        return pattern.matcher(n).matches();
    }

    public static float calc(String input) {
        Stack exp = new Stack();
        StringBuilder curNum = new StringBuilder();
        char curOperation = ' ';
        int res = 0;

        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);

            if (isNumeric(String.valueOf(curChar))) {
                curNum.append(curChar);
            }
            else {
                if (curOperation != ' ') {
                    switch (curOperation) {
                        case '*':
                            System.out.println(curNum);
                            exp.push((Integer)exp.pop() * Integer.parseInt(String.valueOf(curNum)));
                    }
                    curOperation = ' ';
                }
                if (curChar == '+' || curChar == '-') {
                    exp.push(Integer.parseInt(String.valueOf(curNum)));
                    curNum = new StringBuilder("");
                }
                else if (curChar == '*' || curChar == '/') {
                    curOperation = curChar;
                }
            }
        }
        System.out.println(exp);
        return 1;
    }
    public static void main(String[] args) {
        calc("2+3+12");
    }
}
