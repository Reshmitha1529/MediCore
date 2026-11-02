class TriageAssessment {

    // Variables
    private int assessmentId;
    private int patientId;
    private String symptoms;
    private String priorityLevel;
    private String triageTime;

    // Constructor
    public TriageAssessment(int assessmentId, int patientId, String symptoms, String triageTime) {
        this.assessmentId = assessmentId;
        this.patientId = patientId;
        this.symptoms = symptoms;
        this.triageTime = triageTime;
    }

    // assessPatient()
    public void assessPatient() {
        System.out.println("Assessing patient based on symptoms...");
    }

    // assignPriority()
    public void assignPriority() {
        if (symptoms.toLowerCase().contains("heart attack")
                || symptoms.toLowerCase().contains("unconscious")) {
            priorityLevel = "Critical";
        } else if (symptoms.toLowerCase().contains("chest pain")
                || symptoms.toLowerCase().contains("breathing problem")) {
            priorityLevel = "High";
        } else if (symptoms.toLowerCase().contains("fever")) {
            priorityLevel = "Medium";
        } else {
            priorityLevel = "Low";
        }
    }

    // updatePriority()
    public void updatePriority(String newPriority) {
        priorityLevel = newPriority;
    }

    // displayAssessment()
    public void displayAssessment() {
        System.out.println("Assessment ID : " + assessmentId);
        System.out.println("Patient ID    : " + patientId);
        System.out.println("Symptoms      : " + symptoms);
        System.out.println("Priority Level: " + priorityLevel);
        System.out.println("Triage Time   : " + triageTime);
    }

    public static void main(String[] args) {

        TriageAssessment patient1 =
                new TriageAssessment(101, 1001, "Chest Pain", "10:30 AM");

        patient1.assessPatient();
        patient1.assignPriority();
        patient1.displayAssessment();
    }
}

Sample Output
Assessing patient based on symptoms...
Assessment ID : 101
Patient ID    : 1001
Symptoms      : Chest Pain
Priority Level: High
Triage Time   : 10:30 AM import java.util.Scanner;

class EmergencyPatient {
    int patientId;
    String patientName;
    int age;
    String gender;
    String bloodGroup;
    long mobileNumber;

    // Register Patient
    void registerPatient() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        patientId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        patientName = sc.nextLine();

        System.out.print("Enter Age: ");
        age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        gender = sc.nextLine();

        System.out.print("Enter Blood Group: ");
        bloodGroup = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        mobileNumber = sc.nextLong();
    }

    // Update Patient
    void updatePatient() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter New Mobile Number: ");
        mobileNumber = sc.nextLong();
    }

    // Display Patient
    void displayPatient() {
        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Mobile Number: " + mobileNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        EmergencyPatient patient = new EmergencyPatient();

        patient.registerPatient();
        patient.displayPatient();

        patient.updatePatient();

        System.out.println("\nAfter Update:");
        patient.displayPatient();
    }
}

