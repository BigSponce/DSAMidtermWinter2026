import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class PatientHistoryTest {

    @Test
    void navigation() {
        PatientHistory history = new PatientHistory();
        assertNotNull(history.nextRecord());
        assertNotNull(history.previousRecord());
    }

    @Test
    void bounds() {
        PatientHistory history = new PatientHistory();
        // Go to the end
        while(history.nextRecord() != null);
        assertNull(history.nextRecord());

        // Go to the beginning
        while(history.previousRecord() != null);
        assertNull(history.previousRecord());
    }
}
