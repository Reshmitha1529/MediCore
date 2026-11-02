package project;

import java.util.Scanner;

public class ReportGenerationService {

    int patientId;
    String patientName;
    String doctorName;
    String diagnosis;
    String treatment;
    String treatmentStatus;

    void createReport(int pId, String pName, String dName,
                      String diag, String treat, String status) {

        patientId = pId;
        patientName = pName;
        doctorName = dName;
        diagnosis = diag;
        treatment = treat;
        treatmentStatus = status;

        System.out.println("Report generated successfully.");
    }

    void displayReport() {

        System.out.println("\n=================================");
        System.out.println("     EMERGENCY ROOM REPORT");
        System.out.println("=================================");

        System.out.println("Patient ID       : " + patientId);
        System.out.println("Patient Name     : " + patientName);
        System.out.println("Doctor Name      : " + doctorName);
        System.out.println("Diagnosis        : " + diagnosis);
        System.out.println("Treatment        : " + treatment);
        System.out.println("Treatment Status : " + treatmentStatus);

        System.out.println("=================================");
    }

    void updateReport(String newTreatment, String newStatus) {

        treatment = newTreatment;
        treatmentStatus = newStatus;

        System.out.println("Report updated successfully.");
    }

    void closeReport() {

        treatmentStatus = "Completed";

        System.out.println("Report closed successfully.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReportGenerationService report =
                new ReportGenerationService();

        System.out.print("Enter Patient ID: ");
        int pId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String pName = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String dName = sc.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diag = sc.nextLine();

        System.out.print("Enter Treatment: ");
        String treat = sc.nextLine();

        System.out.print("Enter Treatment Status: ");
        String status = sc.nextLine();

        report.createReport(
                pId,
                pName,
                dName,
                diag,
                treat,
                status
        );

        report.displayReport();

        sc.close();
    }
}