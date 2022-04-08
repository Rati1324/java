package Files;

import java.io.*;

public class FileOperations {
    public void write(String s, String folderName, String fileName) {
        try {
            FileWriter w = new FileWriter(folderName + "/" + fileName, true);
            w.write(s);
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(String fileName) {
        try {
            BufferedReader rd = new BufferedReader(new FileReader("myFiles/" + fileName));
            String s;
            while ((s=rd.readLine()) != null) {
                System.out.println(s);
            }
            rd.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
