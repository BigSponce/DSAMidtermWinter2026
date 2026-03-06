import java.util.LinkedList;
import java.util.ListIterator;
import java.time.LocalDate;

public class PatientHistory {
    private LinkedList<PatientRecord> records = new LinkedList<>();
    private ListIterator<PatientRecord> iterator;
    private boolean iteratorInitialized = false;

    public PatientHistory() {
        // Initialize with at least 10 patient history records
        records.add(new PatientRecord(LocalDate.of(2023, 1, 10), "Flu", "Rest and fluids"));
        records.add(new PatientRecord(LocalDate.of(2023, 3, 15), "Check-up", "All clear"));
        records.add(new PatientRecord(LocalDate.of(2023, 5, 20), "Allergy", "Prescribed antihistamines"));
        records.add(new PatientRecord(LocalDate.of(2023, 7, 25), "Sprained Ankle", "RICE method"));
        records.add(new PatientRecord(LocalDate.of(2023, 9, 30), "Cold", "Over-the-counter medication"));
        records.add(new PatientRecord(LocalDate.of(2023, 11, 5), "Vaccination", "Flu shot administered"));
        records.add(new PatientRecord(LocalDate.of(2024, 1, 12), "Migraine", "Prescribed pain relief"));
        records.add(new PatientRecord(LocalDate.of(2024, 4, 18), "Stomach Bug", "Advised bland diet"));
        records.add(new PatientRecord(LocalDate.of(2024, 8, 22), "Minor Cut", "Cleaned and bandaged"));
        records.add(new PatientRecord(LocalDate.of(2025, 2, 9), "Sore Throat", "Prescribed antibiotics"));
        iterator = records.listIterator();
    }

    private void ensureIterator() {
        if (!iteratorInitialized) {
            iterator = records.listIterator();
            iteratorInitialized = true;
        }
    }

    public PatientRecord nextRecord() {
        ensureIterator();
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            System.out.println("No more recent records.");
            return null;
        }
    }

    public PatientRecord previousRecord() {
        ensureIterator();
        if (iterator.hasPrevious()) {
            return iterator.previous();
        } else {
            System.out.println("No older records.");
            return null;
        }
    }

    public void displayNewestRecord() {
        if (!records.isEmpty()) {
            System.out.println("Newest Record: " + records.getLast());
        } else {
            System.out.println("No records available.");
        }
    }

    public void displayOldestRecord() {
        if (!records.isEmpty()) {
            System.out.println("Oldest Record: " + records.getFirst());
        } else {
            System.out.println("No records available.");
        }
    }
    
    public void addPatientRecord(PatientRecord record) {
        records.add(record);
        // Reset iterator
        iterator = records.listIterator();
        iteratorInitialized = true;
    }
}
