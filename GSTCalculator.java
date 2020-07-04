public class GSTCalculator {
    private static GSTCalculator obj = null;

    private GSTCalculator() {

    }

    public static GSTCalculator getInstance() {
        if (obj == null) {
            obj = new GSTCalculator();
        }
        return obj;
    }

    public double getFinalPriceOfItem(double totalPrice, String item) {
        double rate = AllCommodities.getInstance().findGSTRate(item);
        double gst = (totalPrice * rate) / 100.0;
        return totalPrice + gst;
    }

}