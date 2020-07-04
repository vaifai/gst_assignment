import java.util.*;

public class Cosmetics extends Products implements GSTFunctions {
    private double gstRate;
    private static Cosmetics cosmetics = null;
    private static String typeOfProduct = "cosmetics";

    private Cosmetics() {
        gstRate = 28.0;

    }

    public static Cosmetics getInstance() {
        if (cosmetics == null) {
            cosmetics = new Cosmetics();
            AllCommodities.getInstance().addProductObject(typeOfProduct, cosmetics);
            cosmetics.addItem("cream");
            cosmetics.addItem("lotion");
            cosmetics.addItem("perfume");
        }
        return cosmetics;
    }

    // adding item into the cosmetics category
    public void addItem(String item) {
        AllCommodities.getInstance().addProduct(item, typeOfProduct);
    }

    // getters and setters of GST Rates
    @Override
    public double getGSTRate() {
        return cosmetics.gstRate;
        // Overriding the Parent Function
    }

    public void setGSTRate(double rate) {
        cosmetics.gstRate = rate;
    }
}