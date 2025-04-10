import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class RecycleProcessor extends Observable {
    private final List<RecyclableItem> items; // List of accepted items
    private double totalValue; // Total value of recycled items
    private static final int MAX_CAPACITY = 50; // Maximum number of items allowed
    private static final double CAPACITY_WARNING_THRESHOLD = 0.8; // 80% capacity warning

    public RecycleProcessor() {
        this.items = new ArrayList<>();
        this.totalValue = 0;
    }

    public void addObserver(Observer observer) {
        super.addObserver(observer);
    }

    /**
     * Adds an item to the processor if it is valid.
     *
     * @param item The recyclable item to be added.
     * @return True if the item was successfully added, false otherwise.
     */
    public boolean addItem(RecyclableItem item) {
        try {
            if (item == null) {
                throw new IllegalArgumentException("Item cannot be null");
            }
            
            if (!item.isValidItem()) {
                return false;
            }

            checkCapacity();
            
            items.add(item);
            item.compress();
            totalValue += AbstractRecyclableItem.getRecyclablePrice();
            
            // Notify observers about capacity status
            notifyCapacityStatus();
            
            return true;
        } catch (Exception e) {
            ErrorHandler.callOperator("Unexpected error while processing item: " + e.getMessage());
            return false;
        }
    }

    private void notifyCapacityStatus() {
        double capacityRatio = (double) items.size() / MAX_CAPACITY;
        if (capacityRatio >= CAPACITY_WARNING_THRESHOLD) {
            setChanged();
            notifyObservers(new CapacityStatus(items.size(), MAX_CAPACITY, capacityRatio));
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
        return new ArrayList<>(items); // Return a copy to prevent external modification
    }

    public int getCurrentCapacity() {
        return items.size();
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public static class CapacityStatus {
        private final int currentItems;
        private final int maxCapacity;
        private final double capacityRatio;

        public CapacityStatus(int currentItems, int maxCapacity, double capacityRatio) {
            this.currentItems = currentItems;
            this.maxCapacity = maxCapacity;
            this.capacityRatio = capacityRatio;
        }

        public int getCurrentItems() {
            return currentItems;
        }

        public int getMaxCapacity() {
            return maxCapacity;
        }

        public double getCapacityRatio() {
            return capacityRatio;
        }
    }
}

