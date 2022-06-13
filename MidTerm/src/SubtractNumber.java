import java.util.Random;

import static java.util.Objects.isNull;

public class SubtractNumber extends Thread{
    public PrimaryNumber P = new PrimaryNumber();

    public SubtractNumber(int n) {
        P.setNumber(n);
    }

    public SubtractNumber(PrimaryNumber P) {
        this.P = P;
    }

    public void Subtract() {
        Random r = new Random();
        int n = P.getNumber();
        if (n >= 60) {
            P.setNumber(n - r.nextInt(50, 60));
        }
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(currentThread().getName() + ", " + P.getNumber());
        }
    }
}