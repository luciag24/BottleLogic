/**
 * Represents a recyclable bottle.
 */
public class Bottle extends AbstractRecyclableItem {

    private static final double MIN_VOLUME = 250.0; // Minimum volume in milliliters
    private static final double MAX_VOLUME = 2000.0; // Maximum volume in milliliters

    public Bottle(String barcode, double weight, double volume) {
        super(barcode, weight, volume);
    }

    @Override
    public boolean isValidVolume() {
        return getVolume() >= MIN_VOLUME && getVolume() <= MAX_VOLUME;
    }

    @Override
    public void compress() {
        // Logic for compressing the bottle (silent, no output)
    }
}


