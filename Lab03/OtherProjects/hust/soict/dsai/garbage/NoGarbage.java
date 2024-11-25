package hust.soict.dsai.garbage;

import java.io.*;

public class NoGarbage {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/IT3103/Lab03/OtherProjects/hust/soict/dsai/garbage/text.txt");
            int content;
            while ((content = fileInputStream.read()) != -1) {
                sb.append((char) content); 
            }
            fileInputStream.close();
            String result = sb.toString();
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
    }
}
