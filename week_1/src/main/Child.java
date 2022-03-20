package main;

public class Child extends Parent {
    int x, y;

    public Child(){}
    public Child(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int sub() { return y - x; }
    public int add() {
        return x + 2 * y;
    }


}
