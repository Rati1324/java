package Main;

import java.util.Scanner;

public class B extends A {
    protected int y;

    protected B(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected void inputY() {
        Scanner s = new Scanner(System.in);
        this.y = s.nextInt();
    }

    protected int res() {
        return x + (2 * y);
    }
}
