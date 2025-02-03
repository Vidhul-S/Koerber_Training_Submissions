package day6LabAssignment.download;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

class SingleDownloader implements Runnable{
    String [] links;
    public SingleDownloader(){

        try(BufferedReader fi = new BufferedReader(new FileReader("C:\\Users\\vidhul.s\\" +
                "IdeaProjects\\Koreber Training\\src\\day6LabAssignment\\download\\link.txt"));) {

            this.links =(fi.lines()
                    .collect(Collectors.joining("\n")))
                    .split("\n");
        }
        catch(IOException e){

            System.out.println(e.toString());
            this.links = null;
        }
    }
    @Override
    public void run() {

        for(String link : links) {
            System.out.println("Downloading "+link);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class SingleThreadedDownloder {
    public static void main(String[] args) throws InterruptedException {
        SingleDownloader downloader = new SingleDownloader();
        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(downloader);
        thread.start();
        thread.join();
        long stopTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (stopTime - startTime) + " milliseconds.");
    }
}
