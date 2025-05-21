import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OnTrackTaskSubmit {
	
	private List<Task> tasks = new ArrayList<>();
	
	public void taskSubmit(String taskId, String studentId, LocalDateTime dueDate) {
		tasks.add(new Task(taskId, studentId, dueDate));
	}
	
	public boolean markTaskSubmit(String taskId) {
		Task task = taskFind(taskId);
		if(task != null) {
			task.SubmitSet(true);
			return true;
		}
		return false;
	}
	
	public Task taskFind(String taskId) {
		for (Task task : tasks) {
			if(task.getTaskId().equals(taskId)) {
				return task;
			}
		}
		return null;
	}
		
	public String taskStatus(String taskId, LocalDateTime currentTime) {
		Task task = taskFind(taskId);
		if(task == null) {
			return "Task not Found";
		}
		
		boolean submitted = task.isSubmit();
		LocalDateTime dueDate = task.getDuedate();
		
		if (submitted) return "Task Submitted!. You're On Track.";
		
		long timeLeft = Duration.between(currentTime, dueDate).toMinutes();
		
		if (timeLeft < 0) {
			return "Deadline missed!. No Submission made.";
		} else if (timeLeft < 60) {
			return "Less than 1 hour left!. Make submission soon.";
			
		} else if (timeLeft < 1440) {
			return "Less than 24 hours left!. Make submission soon.";
			
		}
		
		return "";
	}
	

}
