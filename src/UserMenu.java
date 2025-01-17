import java.util.Random;

/**
 * Handles user interactions in the BottleLogic system.
 */
public class UserMenu {

    private RecycleProcessor processor;
    private int itemCount; // Counter for items processed
    private static final int IDLE_TIME_BEFORE_STOP = 10000; // 10 seconds in milliseconds

    /**
     * Constructs a new UserMenu with a fresh RecycleProcessor.
     */
    public UserMenu() {
        this.processor = new RecycleProcessor();
        this.itemCount = 0;
    }

    /**
     * Starts the BottleLogic system.
     */
    public void start() {
        System.out.println("Welcome to BottleLogic!");
        System.out.println("Insert items one at a time. The system will process them automatically.");

        long lastActionTime = System.currentTimeMillis(); // Track the last time an action was performed

        while (true) {
            // Check for idle time
            if (System.currentTimeMillis() - lastActionTime > IDLE_TIME_BEFORE_STOP) {
                break; // Exit the loop after 10 seconds of inactivity
            }

            // Simulate user adding an item
            RecyclableItem item = simulateUserInput();

            // Process the item
            processor.addItem(item);
            lastActionTime = System.currentTimeMillis(); // Reset the last action time

            // Check machine capacity
            try {
                processor.checkCapacity();
            } catch (IllegalStateException e) {
                System.out.println("\n--- MACHINE ALERT ---");
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("The machine has stopped. Please contact the operator.");
                break; // Stop the system
            }
        }

        // Print the receipt and exit
        printReceipt();
        System.out.println("Thank you for using BottleLogic!");
    }


        /**
         * Simulates user input for adding an item.
         * This method can be replaced with actual user input handling.
         *
         * @return A randomly generated recyclable item (Bottle or Can).
         */
    private RecyclableItem simulateUserInput() {
        Random random = new Random();
        String barcode = random.nextBoolean() ? "Z12345" : "12345"; // Some valid, some invalid
        double weight = 500 + random.nextDouble() * 500; // Random weight
        double volume = random.nextBoolean() ? 750 : 1000; // Random volume

        if (random.nextBoolean()) {
            return new Bottle(barcode, weight, volume);
        } else {
            return new Can(barcode, weight, volume);
        }
    }

    /**
     * Prints a receipt with the total value of recycled items.
     */
    private void printReceipt() {
        String storeName = "Supermarket Chain XYZ"; // Example store name
        Receipt receipt = new Receipt(processor.getItems(), processor.getTotalValue(), storeName);
        receipt.print();
    }

}


