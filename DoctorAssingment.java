package project;
import java.util.Scanner;
public class DoctorAssignment {
	  int doctorId;
	    String doctorName;
	    String specialization;
	    boolean availability;
	    int assignedPatientId;

	    // Method to add doctor details
	    void addDoctor(int id, String name, String spec, boolean available) {
	        doctorId = id;
	        doctorName = name;
	        specialization = spec;
	        availability = available;
	    }
	    // Method to assign doctor to a patient
	    void assignDoctor(int patientId) {
	        if (availability == true) {
	            assignedPatientId = patientId;
	            availability = false;
	            System.out.println("Doctor assigned successfully.");
	        } else {
	            System.out.println("Doctor is not available.");
	        }
	    }

	    // Method to update doctor availability
	    void updateAvailability(boolean status) {
	        availability = status;
	        System.out.println("Doctor availability updated.");
	    }

	    // Method to display doctor details
	    void displayDoctor() {
	        System.out.println("\n----- Doctor Details -----");
	        System.out.println("Doctor ID           : " + doctorId);
	        System.out.println("Doctor Name         : " + doctorName);
	        System.out.println("Specialization      : " + specialization);
	        System.out.println("Availability         : " + availability);
	        System.out.println("Assigned Patient ID : " + assignedPatientId);
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        DoctorAssignment doctor = new DoctorAssignment();

	        System.out.println("===== DOCTOR ASSIGNMENT MODULE =====");

	        System.out.print("Enter Doctor ID: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Doctor Name: ");
	        String name = sc.nextLine();

	        System.out.print("Enter Specialization: ");
	        String spec = sc.nextLine();

	        System.out.print("Is Doctor Available? (true/false): ");
	        boolean available = sc.nextBoolean();

	        doctor.addDoctor(id, name, spec, available);

	        System.out.print("Enter Patient ID: ");
	        int patientId = sc.nextInt();

	        doctor.assignDoctor(patientId);

	        doctor.displayDoctor();

	        
        
	}

}