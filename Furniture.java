import java.util.*;

public class Furniture extends Products implements GSTFunctions {
    private double gstRate;
    private static Furniture furniture = null;
    private static String typeOfProduct = "furniture";

    private Furniture() {
        gstRate = 5.0;

    }

    public static Furniture getInstance() {
        if (furniture == null) {
            furniture = new Furniture();
            AllCommodities.getInstance().addProductObject(typeOfProduct, furniture);
            furniture.addItem("table");
            furniture.addItem("sofa");
            furniture.addItem("chair");
        }
        return furniture;
    }

    public void addItem(String item) {
        AllCommodities.getInstance().addProduct(item, typeOfProduct);
    }

    // getters and setters of GST Rates
    @Override
    public double getGSTRate() {
        return furniture.gstRate;
        // Overriding the Parent Function
    }

    public void setGSTRate(double rate) {
        furniture.gstRate = rate;
    }
}