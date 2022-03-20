package main;

import java.util.Scanner;

public class Parent {
    int x, y;

    public Parent() {}
    public void input() {
        Scanner s = new Scanner(System.in);
        System.out.println("x:\n");
        this.x = Integer.parseInt(s.nextLine());
        System.out.println("y:\n");
        this.y = Integer.parseInt(s.nextLine());
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public static void main(String args[]) {
        Parent I = new Parent();
        I.input();
        System.out.println(I.getX());
        System.out.println(I.getY());
    }
}
