public class Main {
    public static void main(String[] args) {
        WaitingRoom waitingRoom = new WaitingRoom();

        // Add patients
        waitingRoom.addPatient(new Patient(1, "John Doe", "Fever"));
        waitingRoom.addPatient(new Patient(2, "Jane Smith", "Headache"));
        waitingRoom.addPatient(new Patient(3, "Peter Jones", "Sore Throat"));

        System.out.println("Initial waiting room:");
        waitingRoom.printPatients();
        System.out.println();

        // Serve a patient
        Patient servedPatient = waitingRoom.servePatient();
        System.out.println("Served patient: " + servedPatient);
        System.out.println("Waiting room after serving a patient:");
        waitingRoom.printPatients();
        System.out.println();

        // Insert a patient in an emergency
        waitingRoom.insertPatient(1, new Patient(4, "Mary Brown", "Broken Arm"));
        System.out.println("Waiting room after an emergency insertion:");
        waitingRoom.printPatients();
        System.out.println();

        // Serve all remaining patients
        System.out.println("Serving remaining patients:");
        while (true) {
            Patient p = waitingRoom.servePatient();
            if (p == null) {
                break;
            }
            System.out.println("Served patient: " + p);
        }
        System.out.println();

        // Check empty queue
        System.out.println("Trying to serve from an empty waiting room:");
        waitingRoom.servePatient();
        waitingRoom.printPatients();
    }
}