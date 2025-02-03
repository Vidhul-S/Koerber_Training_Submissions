package day5LabAssignment.storyWordFrequency;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequency {
    @SuppressWarnings("value.unmodified")
    private String [] fileReturner(String fileName){

        boolean c = true;
        String [] returner;
        try(BufferedReader fi = new BufferedReader(new FileReader(fileName))){

            returner = (fi.lines().collect(Collectors.joining("\n"))).toLowerCase().split("\\W+");

        }
        catch(IOException e){

            System.out.println(e.toString());
            c=false;
            returner = null;
        }
        return returner;
    }
    public static void main (String[] args){

        WordFrequency wf = new WordFrequency();
        String [] words = wf.fileReturner("C:\\Users\\vidhul.s\\IdeaProjects\\Koreber Training\\src\\day5LabAssignment\\storyWordFrequency\\story.txt");
        Set <String> uniqueWords = new HashSet<>() ;
        Map <String,Integer> wordCount = new HashMap<>();
        Collections.addAll(uniqueWords, words);
        for (String key : uniqueWords) {

            wordCount.put(key, 0);
        }

        for(String word : uniqueWords){
            int counter=0;
            for(String w : words){
                if(w.equals(word)){
                    counter++;
                }
            }
            wordCount.put(word,counter);
        }

        for (String key : uniqueWords){

            System.out.println(key+" appears "+wordCount.get(key)+" times");
        }
    }
}
