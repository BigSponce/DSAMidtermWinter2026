import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        WaitingRoom waitingRoom = new WaitingRoom();
        PatientHistory patientHistory = new PatientHistory();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Waiting Room");
            System.out.println("2. Patient History");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    waitingRoomMenu(waitingRoom, scanner);
                    break;
                case 2:
                    patientHistoryMenu(patientHistory, scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void waitingRoomMenu(WaitingRoom waitingRoom, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- Waiting Room Menu ---");
            System.out.println("1. Add a new patient");
            System.out.println("2. Serve the next patient");
            System.out.println("3. Insert a patient in an emergency");
            System.out.println("4. View all patients");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter reason for visit: ");
                    String reason = scanner.nextLine();
                    waitingRoom.addPatient(new Patient(id, name, reason));
                    System.out.println("Patient added.");
                    break;
                case 2:
                    Patient servedPatient = waitingRoom.servePatient();
                    if (servedPatient != null) {
                        System.out.println("Served patient: " + servedPatient);
                    }
                    break;
                case 3:
                    System.out.print("Enter position to insert: ");
                    int position = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter patient ID: ");
                    int emergencyId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter patient name: ");
                    String emergencyName = scanner.nextLine();
                    System.out.print("Enter reason for visit: ");
                    String emergencyReason = scanner.nextLine();
                    waitingRoom.insertPatient(position - 1, new Patient(emergencyId, emergencyName, emergencyReason));
                    System.out.println("Patient inserted.");
                    break;
                case 4:
                    waitingRoom.printPatients();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    public static void patientHistoryMenu(PatientHistory patientHistory, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- Patient History Menu ---");
            System.out.println("1. View next record");
            System.out.println("2. View previous record");
            System.out.println("3. View newest record");
            System.out.println("4. View oldest record");
            System.out.println("5. Add a new record");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    PatientRecord next = patientHistory.nextRecord();
                    if (next != null) {
                        System.out.println("Next Record: " + next);
                    }
                    break;
                case 2:
                    PatientRecord prev = patientHistory.previousRecord();
                    if (prev != null) {
                        System.out.println("Previous Record: " + prev);
                    }
                    break;
                case 3:
                    patientHistory.displayNewestRecord();
                    break;
                case 4:
                    patientHistory.displayOldestRecord();
                    break;
                case 5:
                    System.out.print("Enter diagnosis: ");
                    String diagnosis = scanner.nextLine();
                    System.out.print("Enter treatment notes: ");
                    String treatment = scanner.nextLine();
                    patientHistory.addPatientRecord(new PatientRecord(LocalDate.now(), diagnosis, treatment));
                    System.out.println("Patient record added.");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }
}