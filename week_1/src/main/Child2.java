package main;

public class Child2 extends Child {
    int z;
    public Child2(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public float avg() {
        return (this.x + this.y + this.z) / 3;
    }
    public double geoMean() {
        return Math.pow(this.x * this.y * this.z, 1/3);
    }

    public static void main(String args[]) {
        main.Child2 C = new main.Child2(2, 3, 4);
        System.out.println(C.avg());
        System.out.println(C.geoMean());
    }
}