public class AnalysisService {

    public void analyzePatients() {
        System.out.println("Patient Analysis Report");
        System.out.println("-----------------------");
        System.out.println("Total patients treated: 100");
        System.out.println("Patients recovered: 80");
        System.out.println("Patients under treatment: 15");
        System.out.println("Patients referred: 5");
    }

    public void analyzeDoctors() {
        System.out.println("\nDoctor Analysis Report");
        System.out.println("----------------------");
        System.out.println("Total doctors: 10");
        System.out.println("Available doctors: 6");
        System.out.println("Busy doctors: 4");
    }

    public void displayAnalysis() {
        analyzePatients();
        analyzeDoctors();
    }
}