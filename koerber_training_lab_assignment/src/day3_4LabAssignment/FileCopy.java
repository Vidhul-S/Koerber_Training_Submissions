package day3_4LabAssignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class FileCopy {

    public static void main(String[] args) throws java.io.IOException {

        long startTime = System.currentTimeMillis();
        try(FileInputStream fi = new FileInputStream("C:\\Users\\vidhul.s\\IdeaProjects\\Koreber Training\\M4X.avif");
        FileOutputStream fo = new FileOutputStream("C:\\Users\\vidhul.s\\IdeaProjects\\Koreber Training\\src\\day3_4LabAssignment\\M4X.avif");) {

            byte[] buffer = new byte[1] ;
            int bytesRead;
            while ((bytesRead = fi.read(buffer)) != -1) {

                fo.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully (binary).");
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        finally {

            long stopTime = System.currentTimeMillis();
            System.out.println("Execution time: " + (stopTime - startTime) + " milliseconds.");
        }

    }

}
