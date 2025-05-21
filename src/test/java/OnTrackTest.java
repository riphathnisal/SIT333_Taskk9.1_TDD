import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class OnTrackTest {
	
	public OnTrackTaskSubmit result;
	private LocalDateTime now;
	
	@Before
	public void setUp() {
		result = new OnTrackTaskSubmit();
		now = LocalDateTime.of(2025,4,30,10,0);
	}
	
	@Test
	public void testSubmitaTask() {
		result.submitTask("SIT333P1", "s22312", now.plusDays(1));
		Task task = result.findTaskbyID("SIT333P1");
		assertNotNull(task);
		assertEquals("s22312", task.getStudentId());
	}

	
}
