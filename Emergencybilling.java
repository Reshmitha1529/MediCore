import java.util.Scanner;

public class EmergencyBilling {

    // Method to validate billing details
    public static boolean validateService(String serviceName, int customerId, double amount) {

        if (serviceName == null || serviceName.isEmpty()) {
            return false;
        }

        if (customerId <= 0) {
            return false;
        }

        if (amount <= 0) {
            return false;
        }

        return true;
    }

    // Method to calculate final bill
    public static double calculateBill(double amount, double emergencyCharge) {
        return amount + emergencyCharge;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
int patientId;
String serviceName;
double amount;
double emergency Charge;
        System.out.print("Enter Patient ID: ");
        patientId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Emergency Service Name: ");
         serviceName = sc.nextLine();

        System.out.print("Enter Service Amount: ");
         amount = sc.nextDouble();

        System.out.print("Enter Emergency Charge: ");
   emergencyCharge = sc.nextDouble();

        // Validate details
        if (validateService(serviceName, patientId, amount)) {

            double totalBill = calculateBill(amount, emergencyCharge);

            System.out.println("\n----- Emergency Billing -----");
            System.out.println("Patient ID: " + patientId);
            System.out.println("Service: " + serviceName);
            System.out.println("Service Amount: " + amount);
            System.out.println("Emergency Charge: " + emergencyCharge);
            System.out.println("Total Bill: " + totalBill);

        } else {
            System.out.println("Invalid billing details.");
        }

        sc.close();
    }
}