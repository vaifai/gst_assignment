import java.io.*;
import java.util.*;

public class AllCommodities {
    private static AllCommodities allCommodities = null;
    private HashMap<String, String> allItems;
    private HashMap<String, Object> productObjectMap;

    private AllCommodities() {
        allItems = new HashMap<>();
        productObjectMap = new HashMap<>();
        // Object ooo = FoodGrains.getInstance();
        // find((Products) ooo);
    }

    public static AllCommodities getInstance() {
        if (allCommodities == null) {
            allCommodities = new AllCommodities();
            FoodGrains.getInstance();
            Electronics.getInstance();
            Cosmetics.getInstance();
            Furniture.getInstance();
        }
        return allCommodities;
    }

    // This function adds every item into the hashmap along with its type
    public void addProduct(String nameOfProduct, String typeOfProduct) {
        allItems.put(nameOfProduct, typeOfProduct);
        // System.out.println(allItems);
    }

    // This function adds the object of Product type
    public void addProductObject(String product, Object productObject) {
        productObjectMap.put(product, productObject);
    }

    public boolean containsItem(String item) {
        return allItems.containsKey(item);
    }

    public double findGSTRate(String item) {
        Object product = productObjectMap.get(allItems.get(item));
        Products finalProduct = (Products) product;
        // System.out.println("Correct" + prod.getGSTRate());
        return finalProduct.getGSTRate();
    }

}