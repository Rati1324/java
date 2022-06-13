package main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Task_2 {
    public String rootDir = "rootDir";
    public String curDir = "\\";
    public Scanner s = new Scanner(System.in);

    public void createDir() {
        try {
            //System.out.println("Enter drive name:");
            //char drive = s.next().charAt(0);
            System.out.println("Enter folder name:");
            String name = s.next();

            String dir = rootDir + "\\" + "test";
            File f = new File(dir);
            System.out.println(f.mkdir());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile() {
        System.out.println("Enter file content:");
        String content = s.next();
    }

    public void createFile() {
        System.out.println("Enter file name:");
        String fileName = s.next();
        try {
            File f = new File(rootDir + "\\" + fileName + ".txt");
            if (f.createNewFile()) {
                System.out.println("File created successfully");
            }
            else {
                System.out.println("File could not be created");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createControl() {
        System.out.println("Create new:\n0. Directory\n1. File");
        int action = s.nextInt();
        switch (action) {
            case 0 -> createDir();
            case 1 -> createFile();
            default -> {
            }
        }
    }

    public void T() {
        //createDir();
        int action;
        while (true){
            File f = new File(rootDir + curDir);
            String[] names = f.list();
            for (int i = 0; i < Objects.requireNonNull(names).length; i++) {
                System.out.println(i + 1 + ". " + names[i]);
            }
            System.out.println("---------------------");
            System.out.println("Enter a number to read\n");
            action = s.nextInt();
            curDir = curDir.concat(names[action - 1]);
        }
    }
}