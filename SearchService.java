package project;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchService {

    ArrayList<String> patientList = new ArrayList<String>();
    ArrayList<String> doctorList = new ArrayList<String>();
    ArrayList<String> treatmentList = new ArrayList<String>();

    void addPatient(String patient) {
        patientList.add(patient);
    }

    void addDoctor(String doctor) {
        doctorList.add(doctor);
    }

    void addTreatment(String treatment) {
        treatmentList.add(treatment);
    }

    void searchPatient(String patientName) {

        boolean found = false;

        for (String patient : patientList) {

            if (patient.equalsIgnoreCase(patientName)) {

                System.out.println("Patient Found: " + patient);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    void searchDoctor(String doctorName) {

        boolean found = false;

        for (String doctor : doctorList) {

            if (doctor.equalsIgnoreCase(doctorName)) {

                System.out.println("Doctor Found: " + doctor);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Doctor not found.");
        }
    }

    void searchTreatment(String treatmentName) {

        boolean found = false;

        for (String treatment : treatmentList) {

            if (treatment.equalsIgnoreCase(treatmentName)) {

                System.out.println("Treatment Found: " + treatment);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Treatment not found.");
        }
    }

    void displayAll() {

        System.out.println("\n----- Patient List -----");

        for (String patient : patientList) {
            System.out.println(patient);
        }

        System.out.println("\n----- Doctor List -----");

        for (String doctor : doctorList) {
            System.out.println(doctor);
        }

        System.out.println("\n----- Treatment List -----");

        for (String treatment : treatmentList) {
            System.out.println(treatment);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SearchService search = new SearchService();

        search.addPatient("Rahul");
        search.addPatient("Anjali");
        search.addPatient("Kiran");

        search.addDoctor("Dr. Ravi");
        search.addDoctor("Dr. Priya");
        search.addDoctor("Dr. Kumar");

        search.addTreatment("Emergency Treatment");
        search.addTreatment("First Aid");
        search.addTreatment("Medication");

        search.displayAll();

        System.out.print("\nEnter patient name to search: ");
        String patientName = sc.nextLine();

        search.searchPatient(patientName);

        System.out.print("\nEnter doctor name to search: ");
        String doctorName = sc.nextLine();

        search.searchDoctor(doctorName);

        System.out.print("\nEnter treatment to search: ");
        String treatmentName = sc.nextLine();

        search.searchTreatment(treatmentName);

        sc.close();
    }
}