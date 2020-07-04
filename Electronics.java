import java.util.*;

public class Electronics extends Products implements GSTFunctions {
    private double gstRate;
    private static Electronics electronics = null;
    private static String typeOfProduct = "electronics";

    private Electronics() {
        gstRate = 18.0;

    }

    public static Electronics getInstance() {
        if (electronics == null) {
            electronics = new Electronics();
            AllCommodities.getInstance().addProductObject(typeOfProduct, electronics);
            electronics.addItem("mobile");
            electronics.addItem("tv");
            electronics.addItem("tablet");
        }
        return electronics;
    }

    public void addItem(String item) {
        AllCommodities.getInstance().addProduct(item, typeOfProduct);
    }

    // getters and setters of GST Rates
    @Override
    public double getGSTRate() {
        return electronics.gstRate;
        // Overriding the Parent Function
    }

    public void setGSTRate(double rate) {
        electronics.gstRate = rate;
    }
}