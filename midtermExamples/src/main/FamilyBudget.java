package main;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FamilyBudget {
    Scanner s = new Scanner(System.in);
    private int money;
    private String status;

    public int getMoney() { return money; }
    public String getStatus() { return status; }

    protected void insertMoney() {
        System.out.println("Enter amount:");
        try {
            money = s.nextInt();
            findStatus();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
    protected void editMoney() {
        System.out.println("Enter amount to add:");
        try {
            money += s.nextInt();
            findStatus();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    protected void findStatus() {
        if (money > 40000) { status = "Rich"; }
        else if (money > 10000) { status = "Mid"; }
        else { status = "Poor"; }
    }

    protected void writeStatus() {
        try {
            FileWriter w = new FileWriter("family.txt", true);
            w.write(status + " - " + money + "\n");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
