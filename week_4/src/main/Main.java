package main;

import Files.FileOperations;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static Files.FileOperations f = new FileOperations();

    public static void task2() {
        String data = "";
        for (int i = 0; i < 100; i++) {
            data += String.valueOf(i) + "\n";
        }
        f.write(data, "myFiles", "data1.txt");
    }

    public static void task4() {
        for (int i = 1; i < 10; i++) {
            f.write("programmer" + String.valueOf(i), "myFiles2", "file" + String.valueOf(i));
        }
    }

    public static void task10(int dec) {
        while (dec > 0) {
            System.out.println(dec%2);
            dec /= 2;
        }
    }

    public static void task15(List<ArrayList<Integer>> cords) {
        char[][] x = new char[50][50];
        Random r = new Random();

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                if (j == 49 && i < 49) {x[i][j] = '\n';}
                else {x[i][j] = ' ';}
            }
        }
        for (var c : cords) {
            x[c.get(0) - 1][c.get(1) - 1] = (char)(r.nextInt(0, 2) + 48);
        }

        try {
            FileWriter w = new FileWriter("text.txt", true);
            for (int i = 0; i < x.length; i++) {
                for (int j = 0; j < x.length; j++) {
                    w.write(x[i][j]);
                }
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main (String args[]) {
        List<ArrayList<Integer>> cords = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row;
        char status = 'c';
        Scanner s = new Scanner(System.in);
        while (status == 'c') {
            row = new ArrayList<Integer>();
            System.out.println("Enter row (positive integer):");
            row.add(s.nextInt());
            System.out.println("Enter col (positive integer):");
            row.add(s.nextInt());
            System.out.println("Enter 'q' to write or 'c' to continue adding coordinates");
            status = s.next().charAt(0);
            cords.add(row);
        }
        task15(cords);
    }
}