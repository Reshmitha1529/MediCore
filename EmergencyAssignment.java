package project;
import java.util.Scanner; 
public class EmergencyAssignment {
	 int treatmentId;
	    int patientId;
	    String diagnosis;
	    String treatmentProvided;
	    String treatmentStatus;

	    // Method to start treatment
	    void startTreatment(int tId, int pId, String diag, String treatment) {
	        treatmentId = tId;
	        patientId = pId;
	        diagnosis = diag;
	        treatmentProvided = treatment;
	        treatmentStatus = "Under Treatment";

	        System.out.println("Treatment started successfully.");
	    }

	    // Method to update treatment
	    void updateTreatment(String newTreatment) {
	        treatmentProvided = newTreatment;
	        treatmentStatus = "Stable";

	        System.out.println("Treatment updated successfully.");
	    }

	    // Method to discharge patient
	    void dischargePatient() {
	        treatmentStatus = "Discharged";

	        System.out.println("Patient discharged successfully.");
	    }

	    // Method to display treatment details 
	    void displayTreatment() {
	        System.out.println("\n----- Emergency Treatment Details -----");
	        System.out.println("Treatment ID      : " + treatmentId);
	        System.out.println("Patient ID        : " + patientId);
	        System.out.println("Diagnosis         : " + diagnosis);
	        System.out.println("Treatment Provided: " + treatmentProvided);
	        System.out.println("Treatment Status  : " + treatmentStatus);
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        EmergencyAssignment treatment = new EmergencyAssignment();

	        System.out.println("===== EMERGENCY TREATMENT MODULE =====");

	        System.out.print("Enter Treatment ID: ");
	        int tId = sc.nextInt();

	        System.out.print("Enter Patient ID: ");
	        int pId = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Diagnosis: ");
	        String diag = sc.nextLine();

	        System.out.print("Enter Treatment Provided: ");
	        String treatmentGiven = sc.nextLine();
	        treatment.startTreatment(tId, pId, diag, treatmentGiven);

	        treatment.displayTreatment();

	    }
	}