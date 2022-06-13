import java.util.Random;
import java.util.Scanner;

public class Task1 implements Task1I{
    public int a;
    public int b;
    public int[] arr = new int[12];

    public void valueInput() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter a:");
            System.out.println("Enter b:");
            a = s.nextInt();
            b = s.nextInt();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void arrayInput(int a, int b) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(a, b);
        }

    }
    public int min() {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) { min = arr[i]; }
        }
        return min;
    }
    public int[] positive() {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) res[i] = arr[i];
        }
        return res;
    }
    public void index() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ". " + arr[i]);
        }
    }
}
