import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Number of units,Commodity and Unit Price");
        System.out.println("separated by space. Press only 0 to exit");
        String input[] = br.readLine().split(" ");
        AllCommodities allCommodities = AllCommodities.getInstance();
        while (true) {
            if (input.length == 1) {
                try {
                    int x = Integer.parseInt(input[0]);
                    if (x == 0)
                        break;
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer for Number of Units");
                    System.out.println("and a valid real number for the unit price");
                    System.out.println("or 0 to end");
                }

            }
            if (input.length != 3) {
                System.out.println("Please enter in the same order as specified above");
                // continue;
            } else {
                try {
                    int numOfUnits = Integer.parseInt(input[0]);
                    String commodity = input[1].trim().toLowerCase();
                    double unitPrice = Double.parseDouble(input[2]);
                    commodity.trim().toLowerCase();
                    if (allCommodities.containsItem(commodity) && numOfUnits >= 0) {
                        double totalPrice = numOfUnits * unitPrice;
                        System.out.println(GSTCalculator.getInstance().getFinalPriceOfItem(totalPrice, commodity));
                    } else {
                        System.out.println("Please Enter Valid Commodity and positive number of units");
                    }
                    // double gstRate = Cosmetics.getInstance().getGSTRate();
                    // System.out.println(unitPrice * gstRate);

                } catch (Exception e) {
                    System.out.println("Please enter a valid integer for Number of Units");
                    System.out.println("and a valid real number for the unit price");
                    System.out.println("or 0 to end");
                    System.out.println(e);
                }
            }
            input = br.readLine().split(" ");

        }
    }

}