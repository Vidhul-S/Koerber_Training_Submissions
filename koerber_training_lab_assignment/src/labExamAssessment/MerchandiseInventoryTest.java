package labExamAssessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Merchandise {

    private String itemCode;
    private int quantity;
    private double unitPrice;
    public Merchandise(String itemCode, int quantity, double unitPrice) {

        this.itemCode = itemCode;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getItemCode() {

        return itemCode;
    }

    public double getUnitPrice() {

        return unitPrice;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        return sb.append(String.format("%-10s", itemCode)).append(String.format("%5d", quantity)).append(String.format("%8.2f", unitPrice)).toString();
    }
}

public class MerchandiseInventoryTest {

    public static void main(String [] args) throws java.io.IOException{

        ArrayList<Merchandise> merchandises = new ArrayList<>();
        try(BufferedReader fi = new BufferedReader(new FileReader("C:\\Users\\vidhul.s\\IdeaProjects\\Koreber Training\\src\\labExamAssessment\\input.dat"));) {

            String line;
            while ((line = fi.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String itemCode = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double price = Double.parseDouble(parts[2]);
                merchandises.add(new Merchandise(itemCode, quantity, price));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sorted by Item Name Ascending:");
        Collections.sort(merchandises, new Comparator<Merchandise>() {

            @Override
            public int compare(Merchandise m1, Merchandise m2) {

                return m1.getItemCode().compareTo(m2.getItemCode());
            }
        });
        for(Merchandise m:merchandises) {

            System.out.println(m);
        }
        System.out.println("\nSorted by Price (Descending):");
        Collections.sort(merchandises, new Comparator<Merchandise>() {

            @Override
            public int compare(Merchandise m1, Merchandise m2) {

                return Double.compare(m2.getUnitPrice(), m1.getUnitPrice());
            }
        });
        for (Merchandise m : merchandises) {

            System.out.println(m);
        }
    }
}
