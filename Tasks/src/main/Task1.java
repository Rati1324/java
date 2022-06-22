package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Task1 implements ITask1{
    public ArrayList<String> arr = new ArrayList<String>();
    public boolean[] hasLetterA = new boolean[20];
    public void randomString (){
        StringBuilder curString = new StringBuilder();
        Random rn = new Random();
        int curRand;
        boolean[] usedChars = new boolean[126];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 7; j++) {
                curRand = rn.nextInt(33, 126);
                if (!usedChars[curRand]) {
                    if (curRand == 97) { hasLetterA[i] = true; }
                    curString.append((char)curRand);
                    usedChars[curRand] = true;
                }
            }
            Arrays.fill(usedChars, false);
            arr.add(curString.toString());
            curString.setLength(0);
        }
    }

    public void replaceString() {
        Random rn = new Random();
        StringBuilder curString = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (hasLetterA[i]) {
                System.out.println(arr.get(i));
                int curRand;
                for (int j = 0; j < 5; j++) {
                    curRand = rn.nextInt(33, 126);
                    if (curRand != 97) {
                        curString.append((char) curRand);
                    }
                    else { j--; }
                }
                arr.set(i, curString.toString());
            }
        }
    }

    public void editString() {
        Random rn = new Random();
        int randomIndex = rn.nextInt(0, 20);
        int randomChar;
        StringBuilder curString = new StringBuilder("");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                curString.append((char)rn.nextInt(48, 57));
            }
            arr.add(randomIndex, curString.toString());
            curString.setLength(0);
        }
    }

    public void printArr() {
        System.out.println(arr);
    }

    public static void main(String[] args) {
        Task1 t = new Task1();
        t.randomString();
        t.printArr();
    }
}
