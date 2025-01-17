import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Handles the creation and display of a receipt for recycled items.
 */
public class Receipt {
    private List<RecyclableItem> items;
    private double totalValue;
    private String storeName; // Name of the store where the machine is located
    private Date issueDate;

    /**
     * Constructs a new Receipt with the given list of items, total value, and store name.
     *
     * @param items      The list of recycled items.
     * @param totalValue The total refund value.
     * @param storeName  The name of the store where the machine is located.
     */
    public Receipt(List<RecyclableItem> items, double totalValue, String storeName) {
        this.items = items;
        this.totalValue = totalValue;
        this.storeName = storeName;
        this.issueDate = new Date(); // Set the current date
    }

    /**
     * Prints the receipt with a formatted layout.
     */
    public void print() {
        int bottleCount = 0;
        int canCount = 0;

        // Count bottles and cans
        for (RecyclableItem item : items) {
            if (item instanceof Bottle) {
                bottleCount++;
            } else if (item instanceof Can) {
                canCount++;
            }
        }

        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Generate a barcode (dummy for now)
        String barcode = "123456789012";

        System.out.println("\n--- Receipt ---");
        System.out.println("Store: " + storeName);
        System.out.println("Date: " + dateFormat.format(issueDate));
        System.out.println("Barcode: " + barcode);
        System.out.println("--------------------------");
        System.out.println("Items recycled:");
        System.out.printf(" - Bottles: %d\n", bottleCount);
        System.out.printf(" - Cans: %d\n", canCount);
        System.out.println("--------------------------");
        System.out.printf("Total refund: €%.2f%n", totalValue);
        System.out.println("--------------------------");
        System.out.println("Thank you for using BottleLogic!");
        System.out.println("This receipt is valid for 24 hours and can only be used at this store.");
        System.out.println("----------------");
    }
}
