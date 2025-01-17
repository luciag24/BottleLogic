public class ErrorHandler {

    /**
     * Handles critical machine errors by notifying the operator.
     *
     * @param errorMessage The error message to be displayed.
     */
    public static void callOperator(String errorMessage) {
        System.out.println("\n--- MACHINE ALERT ---");
        System.out.println("ERROR: " + errorMessage);
        System.out.println("The machine has stopped. Please contact the operator.");
        // Optionally: Log the error or notify a backend service
    }
}


