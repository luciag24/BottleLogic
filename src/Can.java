/**
 * Represents a recyclable can.
 */
public class Can extends AbstractRecyclableItem {

    private static final double MIN_VOLUME = 250.0; // Minimum volume in milliliters
    private static final double MAX_VOLUME = 1000.0; // Maximum volume in milliliters

    public Can(String barcode, double weight, double volume) {
        super(barcode, weight, volume);
    }

    @Override
    public boolean isValidVolume() {
        return getVolume() >= MIN_VOLUME && getVolume() <= MAX_VOLUME;
    }

    @Override
    public void compress() {
        // Logic for crushing the can (silent, no output)
    }
}



