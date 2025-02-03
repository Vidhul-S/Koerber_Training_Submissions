package day5LabAssignment.BiggestDouble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BigDoub {
    @SuppressWarnings("value.unmodified")
    private List<Double> listReturner(String fileName){

        boolean c = true;
        List <Double> returner = new ArrayList<>();
        try(BufferedReader fi = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = fi.readLine()) != null) {
                returner.add(Double.parseDouble(line));
            }

        }
        catch(IOException e){

            System.out.println(e.toString());
            c=false;
            returner = null;
        }
        return returner;
    }


    public static void main (String[] args){
        BigDoub bd = new BigDoub();
        List<Double> ls = new ArrayList<>();
        ls=bd.listReturner("C:\\Users\\vidhul.s\\IdeaProjects\\Koreber Training\\src\\day5LabAssignment\\BiggestDouble\\data.txt");
        Collections.sort(ls);
        System.out.println(ls);
        System.out.println("Largest Double = "+ls.get(ls.size() - 1));
    }
}
