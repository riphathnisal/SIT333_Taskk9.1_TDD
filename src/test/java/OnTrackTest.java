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
		result.taskSubmit("SIT333P1", "s22312", now.plusDays(1));
		Task task = result.taskFind("SIT333P1");
		assertNotNull(task);
		assertEquals("s22312", task.getStudentId());
	}

	@Test
	public void testStatuslessthanday() {
		result.taskSubmit("SIT333P2", "s22312", now.plusHours(23));
		String output = result.taskStatus("SIT333P2", now);
		assertEquals("Less than 24 hours left!. Make submission soon.", output);
	}
	
	@Test
	public void testStatuslessanHour() {
		result.taskSubmit("SIT333P3", "s22312", now.plusMinutes(55));
		String output = result.taskStatus("SIT333P3", now);
		assertEquals("Less than 1 hour left!. Make submission soon.", output);
	}
	
	@Test
	public void testStatusDeadlinepass() {
		result.taskSubmit("SIT333P4", "s22312", now.minusMinutes(10));
		String output = result.taskStatus("SIT333P4", now);
		assertEquals("Deadline missed!. No Submission made.", output);
	}
	
	@Test
	public void testSubmittedTest() {
		result.taskSubmit("SIT333P5", "s22312", now.plusHours(30));
		result.markTaskSubmit("SIT333P5");
		String output = result.taskStatus("SIT333P5", now);
		assertEquals("Task Submitted!. You're On Track.", output);
	
	}
	
	@Test
	public void taskNotFound() {
		String output = result.taskStatus("NOTASK", now);
		assertEquals("Task not Found", output);
	}
	
	
	
}
