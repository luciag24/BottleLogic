/**
 * A class to test the BottleLogic application.
 */
public class TestBottleLogic {

    public static void main(String[] args) {
        // Create a RecycleProcessor instance
        RecycleProcessor processor = new RecycleProcessor();

        // Create test items
        RecyclableItem bottle1 = new Bottle("Z12345", 750, 1000);
        RecyclableItem can1 = new Can("Z54321", 300, 500);
        RecyclableItem invalidItem = new Bottle("12345", 500, 1500); // Missing symbol 'Z'

        // Test adding items to the processor
        System.out.println("Adding items to the processor:");
        addItemToProcessor(processor, bottle1);
        addItemToProcessor(processor, can1);
        addItemToProcessor(processor, invalidItem);

        // Print receipt
        System.out.println("\n--- Receipt ---");
        processor.displayItems();
        System.out.printf("Total refund: €%.2f%n", processor.getTotalValue());
    }

    private static void addItemToProcessor(RecycleProcessor processor, RecyclableItem item) {
        if (processor.addItem(item)) {
            System.out.println("Item accepted: " + item);
        } else {
            System.out.println("Item rejected: " + item);
        }
    }
}
