package Main;

import java.util.Random;

public class A {
    protected int x;

    public A() {
        System.out.println("hello A class");
    }

    protected void input() {
        Random r = new Random();
        int rand = r.nextInt(1, 2000);
        this.x = rand;
    }

    protected void output() {
        System.out.println(this.x - 1);
    }

    protected boolean primeOrNot() {
        for (int i = 2; i <= Math.sqrt(this.x); i++) {
            if (this.x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
