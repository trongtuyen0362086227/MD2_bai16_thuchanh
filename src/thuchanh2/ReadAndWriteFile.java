package thuchanh2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int max = searchMax(readFile("demothuchanh2"));
        writeFileMax("writemax",max,sc);
    }

    public static List<Integer> readFile(String path) {
        List<Integer> listNumber = new ArrayList<>();
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
            while ((line = br.readLine()) != null) {
                listNumber.add(Integer.parseInt(line));
            }
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
        return listNumber;
    }

    public static void writeFileMax(String filePath, int max, Scanner sc) {
        File file = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            file = new File(filePath);
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            System.out.println("Gia tri max la: "+max);
            String line = sc.nextLine();
            bw.write(line);
            bw.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
               if (bw!=null){
                   bw.close();
               }
               if (osw!=null){
                   osw.close();
               }
               if (fos!=null){
                   fos.close();
               }
            } catch (Exception ex1){
                ex1.printStackTrace();
            }
        }
    }
    public static int searchMax(List<Integer> integerList){
        int max = 0;
        for (int number:integerList) {
          if (number>max){
              max = number;
          }
        }
        return max;
    }
}