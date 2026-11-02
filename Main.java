package project;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);
		        int choice;

		        EmergencyPatient patient = new EmergencyPatient();
		        TriageAssessment triage = new TriageAssessment();
		        DoctorAssignment doctor = new DoctorAssignment();
		        EmergencyAssignment treatment = new EmergencyAssignment();
		        EmergencyBilling billing = new EmergencyBilling();
		        ValidateService validate = new ValidateService();
		        SearchService search = new SearchService();
		        ReportGeneration report = new ReportGeneration();
		        Analaysis_service analysis = new Analaysis_service();

		        do {
		            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
		            System.out.println("1. Register Emergency Patient");
		            System.out.println("2. Triage Assessment");
		            System.out.println("3. Assign Doctor");
		            System.out.println("4. Emergency Treatment");
		            System.out.println("5. Generate Bill");
		            System.out.println("6. Validate Patient Details");
		            System.out.println("7. Search Patient");
		            System.out.println("8. Generate Report");
		            System.out.println("9. Analyze Hospital Data");
		            System.out.println("10. Exit");

		            System.out.print("Enter your choice: ");
		            choice = sc.nextInt();

		            switch (choice) {

		                case 1:
		                    patient.registerPatient();
		                    break;

		                case 2:
		                    triage.assessPatient();
		                    break;

		                case 3:
		                    doctor.assignDoctor();
		                    break;

		                case 4:
		                    treatment.provideTreatment();
		                    break;

		                case 5:
		                    billing.generateBill();
		                    break;

		                case 6:
		                    validate.validate();
		                    break;

		                case 7:
		                    search.search();
		                    break;

		                case 8:
		                    report.generateReport();
		                    break;

		                case 9:
		                    analysis.displayAnalysis();
		                    break;

		                case 10:
		                    System.out.println(
		                        "Thank you for using Hospital Management System!"
		                    );
		                    break;

		                default:
		                    System.out.println(
		                        "Invalid choice! Please enter 1 to 10."
		                    );
		            }

		        } while (choice != 10);

		        sc.close();
		    }
		
	}