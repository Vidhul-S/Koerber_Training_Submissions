package day3_4LabAssignment;

import java.io.*;

public class FileCopyBufferWay {

    public static void main(String[] args) throws java.io.IOException {

        long startTime = System.currentTimeMillis();
        try(BufferedInputStream fi = new BufferedInputStream(new FileInputStream("C:\\Users\\vidhul.s\\IdeaProjects\\Koreber Training\\M4X.avif"));
            BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream("C:\\Users\\vidhul.s\\IdeaProjects\\Koreber Training\\src\\day3_4LabAssignment\\M4X.avif"));) {

            byte[] buffer = new byte[1024]; // Buffer to hold the data
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


