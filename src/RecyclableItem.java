/**
 * Represents a recyclable item that can be accepted by the BottleLogic machine.
 */
public abstract class RecyclableItem {

    private String barcode;
    private double weight;
    private double volume; // volume in milliliters
    private static final double RECYCLABLE_PRICE = 0.15; // Fixed price
    private static final String RECYCLABLE_SYMBOL = "Z"; // Symbol indicating recyclable item

    public RecyclableItem(String barcode, double weight, double volume) {
        this.barcode = barcode;
        this.weight = weight;
        this.volume = volume;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public static double getRecyclablePrice() {
        return RECYCLABLE_PRICE;
    }

    public static String getRecyclableSymbol() {
        return RECYCLABLE_SYMBOL;
    }
    /**
     * Validates the item. Ensures the barcode contains the symbol Z and the volume is valid.
     *
     * @return True if the item is valid, false otherwise.
     */
    public boolean isValidItem() {
        return isValidBarcode() && isValidVolume();
    }

    private boolean isValidBarcode() {
        return barcode != null && barcode.contains("Z");
    }

    public abstract boolean isValidVolume();

    public abstract void compress();

    /**
     * Compresses the recyclable item. Each subclass should provide its own implementation.
     */


    @Override
    public String toString() {
        return "RecyclableItem{" +
                "barcode='" + barcode + '\'' +
                ", weight=" + weight +
                '}';
    }
}


