package project;                                                                        import java.util.*;
import java.util.stream.*;

class EmergencyPatient {
    int patientId, age;
    String patientName, gender, bloodGroup;
    long mobileNumber;

    EmergencyPatient(int id, String name, int age, String gender,
                     String bloodGroup, long mobile) {
        patientId = id;
        patientName = name;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        mobileNumber = mobile;
    }

    void registerPatient() {
        System.out.println("Patient registered successfully!");
    }

    void updatePatient(String name) {
        patientName = name;
    }

    void displayPatient() {
        System.out.println("ID: " + patientId + ", Name: " + patientName
                + ", Age: " + age + ", Mobile: " + mobileNumber);
    }
}

class TriageAssessment {
    int assessmentId, patientId;
    String symptoms, priorityLevel;
    String triageTime;

    TriageAssessment(int id, int pid, String symptoms, String priority) {
        assessmentId = id;
        patientId = pid;
        this.symptoms = symptoms;
        priorityLevel = priority;
        triageTime = new Date().toString();
    }

    void assessPatient() {
        System.out.println("Patient assessed successfully!");
    }

    void assignPriority(String priority) {
        priorityLevel = priority;
    }

    void updatePriority(String priority) {
        priorityLevel = priority;
    }

    void displayAssessment() {
        System.out.println("Patient ID: " + patientId
                + ", Symptoms: " + symptoms
                + ", Priority: " + priorityLevel);
    }
}

class Doctor {
    int doctorId, assignedPatientId;
    String doctorName, specialization;
    boolean availability = true;

    Doctor(int id, String name, String specialization) {
        doctorId = id;
        doctorName = name;
        this.specialization = specialization;
        assignedPatientId = 0;
    }

    void addDoctor() {
        System.out.println("Doctor added successfully!");
    }

    void assignDoctor(int patientId) {
        assignedPatientId = patientId;
        availability = false;
    }

    void updateAvailability(boolean status) {
        availability = status;
    }

    void displayDoctor() {
        System.out.println("Doctor ID: " + doctorId
                + ", Name: " + doctorName
                + ", Specialization: " + specialization
                + ", Available: " + availability);
    }
}

class EmergencyTreatment {
    int treatmentId, patientId;
    String diagnosis, treatmentProvided, treatmentStatus;

    EmergencyTreatment(int id, int pid, String diagnosis,
                       String treatment) {
        treatmentId = id;
        patientId = pid;
        this.diagnosis = diagnosis;
        treatmentProvided = treatment;
        treatmentStatus = "Under Treatment";
    }

    void startTreatment() {
        treatmentStatus = "Under Treatment";
    }

    void updateTreatment(String status) {
        treatmentStatus = status;
    }

    void dischargePatient() {
        treatmentStatus = "Discharged";
    }

    void displayTreatment() {
        System.out.println("Patient ID: " + patientId
                + ", Diagnosis: " + diagnosis
                + ", Treatment: " + treatmentProvided
                + ", Status: " + treatmentStatus);
    }
}

class Billing {
    int billId, patientId;
    double consultationCharge, emergencyCharge, totalBill;
    boolean paid = false;

    Billing(int id, int pid, double consultation, double emergency) {
        billId = id;
        patientId = pid;
        consultationCharge = consultation;
        emergencyCharge = emergency;
        calculateBill();
    }

    void calculateBill() {
        totalBill = consultationCharge + emergencyCharge;
    }

    void generateInvoice() {
        System.out.println("Invoice generated. Total: Rs. " + totalBill);
    }

    void receivePayment() {
        paid = true;
        System.out.println("Payment received successfully.");
    }

    void displayBill() {
        System.out.println("Bill ID: " + billId
                + ", Patient ID: " + patientId
                + ", Total: Rs. " + totalBill
                + ", Paid: " + paid);
    }
}

class ValidateService {
    boolean validatePatientId(int id) {
        return id > 0;
    }

    boolean validateDoctorId(int id) {
        return id > 0;
    }

    boolean validateMobileNumber(long mobile) {
        return mobile >= 1000000000L && mobile <= 9999999999L;
    }

    boolean validateBillAmount(double amount) {
        return amount >= 0;
    }
}

class SearchService {
    ArrayList<EmergencyPatient> patientList;
    ArrayList<Doctor> doctorList;
    ArrayList<TriageAssessment> triageList;
    ArrayList<EmergencyTreatment> treatmentList;

    SearchService(ArrayList<EmergencyPatient> p, ArrayList<Doctor> d,
                  ArrayList<TriageAssessment> a,
                  ArrayList<EmergencyTreatment> t) {
        patientList = p;
        doctorList = d;
        triageList = a;
        treatmentList = t;
    }

    void searchPatient(int id) {
        patientList.stream().filter(p -> p.patientId == id)
                .forEach(EmergencyPatient::displayPatient);
    }

    void searchDoctor(int id) {
        doctorList.stream().filter(d -> d.doctorId == id)
                .forEach(Doctor::displayDoctor);
    }

    void searchAssessment(int id) {
        triageList.stream().filter(a -> a.patientId == id)
                .forEach(TriageAssessment::displayAssessment);
    }

    void searchTreatment(int id) {
        treatmentList.stream().filter(t -> t.patientId == id)
                .forEach(EmergencyTreatment::displayTreatment);
    }
}

class ReportGenerationService {
    void generatePatientReport(ArrayList<EmergencyPatient> list) {
        System.out.println("\n--- Patient Report ---");
        list.forEach(EmergencyPatient::displayPatient);
    }

    void generateTriageReport(ArrayList<TriageAssessment> list) {
        System.out.println("\n--- Triage Report ---");
        list.forEach(TriageAssessment::displayAssessment);
    }

    void generateBillingReport(ArrayList<Billing> list) {
        System.out.println("\n--- Billing Report ---");
        list.forEach(Billing::displayBill);
    }

    void generateTreatmentReport(ArrayList<EmergencyTreatment> list) {
        System.out.println("\n--- Treatment Report ---");
        list.forEach(EmergencyTreatment::displayTreatment);
    }
}

class AnalysisService {
    void priorityWisePatients(ArrayList<TriageAssessment> list) {
        System.out.println("\n--- Priority-wise Patients ---");
        Map<String, Long> map = list.stream().collect(
                Collectors.groupingBy(a -> a.priorityLevel,
                        Collectors.counting()));
        map.forEach((priority, count) ->
                System.out.println(priority + ": " + count));
    }

    void calculateEmergencyRevenue(ArrayList<Billing> list) {
        double revenue = list.stream()
                .filter(b -> b.paid)
                .mapToDouble(b -> b.totalBill).sum();
        System.out.println("Total Revenue: Rs. " + revenue);
    }

    void identifyMostFrequentEmergency(
            ArrayList<EmergencyTreatment> list) {
        Map<String, Long> map = list.stream().collect(
                Collectors.groupingBy(t -> t.diagnosis,
                        Collectors.counting()));

        map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresentOrElse(
                        e -> System.out.println("Most frequent emergency: "
                                + e.getKey() + " (" + e.getValue() + ")"),
                        () -> System.out.println("No treatment records."));
    }

    void generateSummary(ArrayList<EmergencyPatient> patients,
                         ArrayList<TriageAssessment> triage,
                         ArrayList<Billing> bills) {
        System.out.println("\n--- Emergency Summary ---");
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Total Assessments: " + triage.size());
        System.out.println("Total Bills: " + bills.size());
        calculateEmergencyRevenue(bills);
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<EmergencyPatient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<TriageAssessment> triage = new ArrayList<>();
    static ArrayList<EmergencyTreatment> treatments = new ArrayList<>();
    static ArrayList<Billing> bills = new ArrayList<>();

    static ValidateService validator = new ValidateService();
    static ReportGenerationService reports = new ReportGenerationService();
    static AnalysisService analysis = new AnalysisService();

    static int patientCount = 1, doctorCount = 1, assessmentCount = 1;
    static int treatmentCount = 1, billCount = 1;

    static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(value)) return value;
            } catch (NumberFormatException e) {
                // Show the error below.
            }
            System.out.println("Please enter a valid amount.");
        }
    }

    static String readText(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }

    static EmergencyPatient findPatient(int id) {
        return patients.stream()
                .filter(p -> p.patientId == id)
                .findFirst().orElse(null);
    }

    static Doctor findDoctor(int id) {
        return doctors.stream()
                .filter(d -> d.doctorId == id)
                .findFirst().orElse(null);
    }

    static void registerPatient() {
        int id = patientCount++;
        String name = readText("Patient name: ");
        int age = readInt("Age: ");
        String gender = readText("Gender: ");
        String blood = readText("Blood group: ");

        long mobile;
        while (true) {
            try {
                mobile = Long.parseLong(readText("Mobile number: "));
                if (validator.validateMobileNumber(mobile)) break;
            } catch (NumberFormatException e) {
                // Ask again.
            }
            System.out.println("Enter a valid 10-digit mobile number.");
        }

        EmergencyPatient p = new EmergencyPatient(
                id, name, age, gender, blood, mobile);
        patients.add(p);
        p.registerPatient();
        System.out.println("Patient ID: " + id);
    }

    static void assessPatient() {
        int id = readInt("Patient ID: ");
        if (findPatient(id) == null) {
            System.out.println("Patient not found.");
            return;
        }

        String symptoms = readText("Symptoms: ");
        System.out.println("Priority: 1.Critical 2.High 3.Medium 4.Low");
        int choice = readInt("Choose priority: ");

        String[] levels = {"Critical", "High", "Medium", "Low"};
        if (choice < 1 || choice > 4) {
            System.out.println("Invalid priority.");
            return;
        }

        TriageAssessment a = new TriageAssessment(
                assessmentCount++, id, symptoms, levels[choice - 1]);
        triage.add(a);
        a.assessPatient();
        a.displayAssessment();
    }

    static void addDoctor() {
        int id = doctorCount++;
        String name = readText("Doctor name: ");
        String specialization = readText("Specialization: ");
        Doctor d = new Doctor(id, name, specialization);
        doctors.add(d);
        d.addDoctor();
        System.out.println("Doctor ID: " + id);
    }

    static void assignDoctor() {
        int pid = readInt("Patient ID: ");
        if (findPatient(pid) == null) {
            System.out.println("Patient not found.");
            return;
        }

        TriageAssessment a = triage.stream()
                .filter(t -> t.patientId == pid)
                .findFirst().orElse(null);

        if (a == null) {
            System.out.println("Assess the patient before assigning a doctor.");
            return;
        }

        System.out.println("Priority: " + a.priorityLevel);
        for (Doctor d : doctors) {
            if (d.availability) d.displayDoctor();
        }

        int did = readInt("Doctor ID: ");
        Doctor d = findDoctor(did);

        if (d == null || !validator.validateDoctorId(did)
                || !d.availability) {
            System.out.println("Doctor not found or unavailable.");
            return;
        }

        d.assignDoctor(pid);
        System.out.println("Doctor assigned successfully.");
    }

    static void startTreatment() {
        int pid = readInt("Patient ID: ");
        if (findPatient(pid) == null) {
            System.out.println("Patient not found.");
            return;
        }

        String diagnosis = readText("Diagnosis: ");
        String treatment = readText("Treatment provided: ");

        EmergencyTreatment t = new EmergencyTreatment(
                treatmentCount++, pid, diagnosis, treatment);
        treatments.add(t);
        t.startTreatment();
        t.displayTreatment();
    }

    static void updateTreatment() {
        int pid = readInt("Patient ID: ");
        EmergencyTreatment t = treatments.stream()
                .filter(x -> x.patientId == pid)
                .findFirst().orElse(null);

        if (t == null) {
            System.out.println("Treatment not found.");
            return;
        }

        System.out.println("1. Under Treatment  2. Stable  3. Discharged");
        int choice = readInt("Choose status: ");

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice.");
            return;
        }

        String[] status = {"Under Treatment", "Stable", "Discharged"};
        t.updateTreatment(status[choice - 1]);

        if (choice == 3) {
            for (Doctor d : doctors) {
                if (d.assignedPatientId == pid) {
                    d.updateAvailability(true);
                    d.assignedPatientId = 0;
                }
            }
        }

        t.displayTreatment();
    }

    static void generateBill() {
        int pid = readInt("Patient ID: ");
        if (findPatient(pid) == null) {
            System.out.println("Patient not found.");
            return;
        }

        double consultation = readDouble("Consultation charge: ");
        double emergency = readDouble("Emergency charge: ");

        if (!validator.validateBillAmount(consultation)
                || !validator.validateBillAmount(emergency)) {
            System.out.println("Invalid bill amount.");
            return;
        }

        Billing b = new Billing(billCount++, pid, consultation, emergency);
        bills.add(b);
        b.generateInvoice();
        b.displayBill();
    }

    static void receivePayment() {
        int id = readInt("Bill ID: ");
        Billing b = bills.stream()
                .filter(x -> x.billId == id)
                .findFirst().orElse(null);

        if (b == null) {
            System.out.println("Bill not found.");
        } else if (b.paid) {
            System.out.println("Bill already paid.");
        } else {
            b.receivePayment();
        }
    }

    static void searchRecords() {
        SearchService s = new SearchService(
                patients, doctors, triage, treatments);

        System.out.println("1.Patient 2.Doctor 3.Triage 4.Treatment");
        int choice = readInt("Choose search type: ");
        int id = readInt("Enter ID: ");

        switch (choice) {
            case 1: s.searchPatient(id); break;
            case 2: s.searchDoctor(id); break;
            case 3: s.searchAssessment(id); break;
            case 4: s.searchTreatment(id); break;
            default: System.out.println("Invalid choice.");
        }
    }

    static void showReports() {
        System.out.println("1.Patients 2.Triage 3.Billing 4.Treatment");
        int choice = readInt("Choose report: ");

        switch (choice) {
            case 1: reports.generatePatientReport(patients); break;
            case 2: reports.generateTriageReport(triage); break;
            case 3: reports.generateBillingReport(bills); break;
            case 4: reports.generateTreatmentReport(treatments); break;
            default: System.out.println("Invalid choice.");
        }
    }

    static void showAnalysis() {
        analysis.priorityWisePatients(triage);
        analysis.calculateEmergencyRevenue(bills);
        analysis.identifyMostFrequentEmergency(treatments);
        analysis.generateSummary(patients, triage, bills);
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== MEDICORE HOSPITAL SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Triage Assessment");
            System.out.println("3. Add Doctor");
            System.out.println("4. Assign Doctor");
            System.out.println("5. Start Treatment");
            System.out.println("6. Update Treatment / Discharge");
            System.out.println("7. Generate Emergency Bill");
            System.out.println("8. Receive Payment");
            System.out.println("9. Search Records");
            System.out.println("10. Generate Reports");
            System.out.println("11. Emergency Analysis");
            System.out.println("12. Display All Doctors");
            System.out.println("0. Exit");

            choice = readInt("Enter choice: ");

            try {
                switch (choice) {
                    case 1: registerPatient(); break;
                    case 2: assessPatient(); break;
                    case 3: addDoctor(); break;
                    case 4: assignDoctor(); break;
                    case 5: startTreatment(); break;
                    case 6: updateTreatment(); break;
                    case 7: generateBill(); break;
                    case 8: receivePayment(); break;
                    case 9: searchRecords(); break;
                    case 10: showReports(); break;
                    case 11: showAnalysis(); break;
                    case 12:
                        doctors.forEach(Doctor::displayDoctor);
                        break;
                    case 0:
                        System.out.println("Thank you for using MediCore!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}