import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WaitingRoomTest {

    @Test
    void addAndServePatient() {
        WaitingRoom waitingRoom = new WaitingRoom();
        Patient patient = new Patient(1, "Test Patient", "Testing");
        waitingRoom.addPatient(patient);
        assertEquals(patient, waitingRoom.servePatient());
        assertNull(waitingRoom.servePatient());
    }
}
