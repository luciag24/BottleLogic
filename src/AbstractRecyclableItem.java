/**
 * Abstract base class implementing common functionality for recyclable items.
 */
public abstract class AbstractRecyclableItem implements RecyclableItem {
    private String barcode;
    private double weight;
    private double volume; // volume in milliliters
    private static final double RECYCLABLE_PRICE = 0.15; // Fixed price
    private static final String RECYCLABLE_SYMBOL = "Z"; // Symbol indicating recyclable item

    protected AbstractRecyclableItem(String barcode, double weight, double volume) {
        this.barcode = barcode;
        this.weight = weight;
        this.volume = volume;
    }

    @Override
    public String getBarcode() {
        return barcode;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    public static double getRecyclablePrice() {
        return RECYCLABLE_PRICE;
    }

    public static String getRecyclableSymbol() {
        return RECYCLABLE_SYMBOL;
    }

    @Override
    public boolean isValidItem() {
        return isValidBarcode() && isValidVolume();
    }

    private boolean isValidBarcode() {
        return barcode != null && barcode.contains(RECYCLABLE_SYMBOL);
    }

    @Override
    public String toString() {
        return "RecyclableItem{" +
                "barcode='" + barcode + '\'' +
                ", weight=" + weight +
                '}';
    }

    public abstract boolean isValidVolume();

    public abstract void compress();
} 