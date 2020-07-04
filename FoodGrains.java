import java.util.*;

public class FoodGrains extends Products implements GSTFunctions {
    private double gstRate;
    private static FoodGrains foodGrains = null;
    private static String typeOfProduct = "food_grain";

    private FoodGrains() {
        gstRate = 0.0;

    }

    public static FoodGrains getInstance() {
        if (foodGrains == null) {
            foodGrains = new FoodGrains();
            AllCommodities.getInstance().addProductObject(typeOfProduct, foodGrains);
            foodGrains.addItem("rice");
            foodGrains.addItem("wheat");
            foodGrains.addItem("dal");
        }
        return foodGrains;
    }

    public void addItem(String item) {
        AllCommodities.getInstance().addProduct(item, typeOfProduct);
    }

    // getters and setters of GST Rates
    @Override
    public double getGSTRate() {
        return foodGrains.gstRate;
        // Overriding the Parent Function
    }

    public void setGSTRate(double rate) {
        foodGrains.gstRate = rate;
    }
}