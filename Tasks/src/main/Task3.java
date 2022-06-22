package main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        String input;
//        String[] result = new String[5];
        ArrayList<String> result = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a 2 digit number:");

        input = s.nextLine();

        if (input.charAt(0) != input.charAt(1)) {
            result.add(String.valueOf(input.charAt(0)));
            result.add(String.valueOf(input.charAt(1)));
            result.add(String.valueOf(input.charAt(1)) + String.valueOf(input.charAt(0)));
            result.add(String.valueOf(input.charAt(0)) + String.valueOf(input.charAt(0)));
            result.add(String.valueOf(input.charAt(1)) + String.valueOf(input.charAt(1)));
        }
        else {
            result.add(String.valueOf(input.charAt(0)));
        }

        try {
            FileWriter w = new FileWriter("num.txt", true);
            for (String i : result) {
                w.write(i + "\n");
            }
            w.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
