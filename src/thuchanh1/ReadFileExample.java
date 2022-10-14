package thuchanh1;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args) {
        addIntinText("demofile");
    }

    public static void addIntinText(String path) {
        File file = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            file = new File(path);
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            System.out.println("Cac so trong file la");
            String line = br.readLine();
            int num = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                num += Integer.parseInt(line);
            }
            System.out.printf("tong cac so trong file la: %d", num);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
