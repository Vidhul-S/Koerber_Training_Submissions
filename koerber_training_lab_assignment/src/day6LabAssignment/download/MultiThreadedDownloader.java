package day6LabAssignment.download;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MultiDownloader implements Runnable{
    String link;

    public MultiDownloader(String link) {
        this.link = link;
    }

    @Override
    public void run() {
        System.out.println("Downloading " + link);
        try {
            Thread.sleep(500); // Simulate download delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class MultiThreadedDownloader {
    public static void main(String[] args) throws InterruptedException {
        String[] links;
        try (BufferedReader fi = new BufferedReader(new FileReader("C:\\Users\\vidhul.s\\" +
                "IdeaProjects\\Koreber Training\\src\\day6LabAssignment\\download\\link.txt"))) {
            links = fi.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        long startTime = System.currentTimeMillis();
        for (String link:links){
            MultiDownloader downloader = new MultiDownloader(link);
            Thread thread = new Thread(downloader);
            thread.start();
        }
        long stopTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (stopTime - startTime) + " milliseconds.");
    }
}

