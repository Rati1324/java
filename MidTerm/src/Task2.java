import java.io.*;
import java.util.Random;

public class Task2 {
    public void write(int n) {
        Random r = new Random();
        try {
            FileWriter w = new FileWriter("numbers.txt", true);
            for (int i = 0; i < n; i++) {
                w.write(String.valueOf(r.nextInt(-12, 23)) + "\n");
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sum() {
        int res = 0;
        try {
            BufferedReader rd = new BufferedReader(new FileReader("numbers.txt"));
            String s;
            while ((s=rd.readLine()) != null) {
                res += Integer.parseInt(s);
            }
            rd.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
}
