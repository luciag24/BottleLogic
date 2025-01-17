import java.util.ArrayList;
import java.util.List;

public class RecycleProcessor {
    private final List<RecyclableItem> items; // List of accepted items
    private double totalValue; // Total value of recycled items
    private static final int MAX_CAPACITY = 50; // Maximum number of items allowed

    public RecycleProcessor() {
        this.items = new ArrayList<>();
        this.totalValue = 0;
    }

    /**
     * Adds an item to the processor if it is valid.
     *
     * @param item The recyclable item to be added.
     * @return True if the item was successfully added, false otherwise.
     */
    public boolean addItem(RecyclableItem item) {
        try {
            if (item.isValidItem()) {
                items.add(item);
                item.compress();
                totalValue += RecyclableItem.getRecyclablePrice();
                return true;
            } else {

                return false;
            }
        } catch (Exception e) {
            ErrorHandler.callOperator("Unexpected error while processing item: " + e.getMessage());
            return false;
        }
    }

    /**
     * Checks if the processor has reached its maximum capacity.
     *
     * @throws IllegalStateException If the processor is full.
     */
    public void checkCapacity() {
        if (items.size() >= MAX_CAPACITY) {
            throw new IllegalStateException("Machine is full. Please empty the container.");
        }
    }

    /**
     * Displays all recycled items.
     */
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items have been recycled yet.");
        } else {
            items.forEach(System.out::println);
        }
    }

    /**
     * Gets the total value of recycled items.
     *
     * @return The total refund value.
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * Gets the list of recycled items.
     *
     * @return The list of recycled items.
     */
    public List<RecyclableItem> getItems() {
        return items;
    }
}

