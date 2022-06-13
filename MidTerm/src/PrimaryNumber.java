import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PrimaryNumber {
    private int number;
    public void setNumber (int n) {number = n; writeChange();}
    public int getNumber () {return number;}

    public void value() {
        Random r = new Random();
        setNumber(r.nextInt(100, 200));
    }

    public void writeChange() {
        try {
            FileWriter w = new FileWriter("number.txt", true);
            w.write(String.valueOf(number) + "\n");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
