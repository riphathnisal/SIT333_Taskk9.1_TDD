import java.time.LocalDateTime;
public class Task {
	
	private String taskId;
	private String studentId;
	private LocalDateTime dueDate;
	private boolean submit;
	
	public Task(String taskId, String studentId, LocalDateTime dueDate) {
		
		this.taskId = taskId;
		this.studentId = studentId;
		this.dueDate = dueDate;
		this.submit = false;
	}
	
	public String getTaskId () {return taskId;}
	public String getStudentId () {return studentId;}
	public LocalDateTime getDuedate () {return dueDate;}
	public boolean isSubmit () {return submit;}
	
	
	public void SubmitSet(boolean submit) {
		this.submit = submit;
	}

}
