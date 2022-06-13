public class Main {
    public static void main(String[] args) {
        PrimaryNumber p = new PrimaryNumber();
        p.setNumber(23);

        SubtractNumber s = new SubtractNumber(p);
        SubtractNumber s2 = new SubtractNumber(p);
        s.start();
        s2.start();
    }
}
