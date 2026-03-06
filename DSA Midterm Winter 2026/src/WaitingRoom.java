import java.util.LinkedList;

public class WaitingRoom {
    private LinkedList<Patient> waitingQueue = new LinkedList<>();

    public void addPatient(Patient patient) {
        waitingQueue.add(patient);
    }

    public Patient servePatient() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No patients in the waiting room.");
            return null;
        }
        return waitingQueue.poll();
    }

    public void insertPatient(int position, Patient patient) {
        if (position < 0 || position > waitingQueue.size()) {
            System.out.println("Invalid position.");
            return;
        }
        waitingQueue.add(position, patient);
    }

    public void printPatients() {
        if (waitingQueue.isEmpty()) {
            System.out.println("No patients in the waiting room.");
            return;
        }
        System.out.println("Patients in the waiting room:");
        for (Patient patient : waitingQueue) {
            System.out.println(patient);
        }
    }
}