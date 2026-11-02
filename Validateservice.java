import java.util.Scanner;

class ValidateService {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
int customerId;
String serviceName;
double amount;

        System.out.print("Enter Customer ID: ");
       customerId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Service Name: ");
       serviceName = sc.nextLine();

        System.out.print("Enter Service Amount: ");
       amount = sc.nextDouble();

        boolean result = validateService(serviceName, customerId, amount);

        if (result) {
            System.out.println("Service is Valid");
        } else {
            System.out.println("Service is Invalid");
        }

        sc.close();
    }
}