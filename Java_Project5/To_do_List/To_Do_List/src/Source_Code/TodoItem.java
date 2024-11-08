package Source_Code;

import java.io.Serializable;

public class TodoItem implements Serializable {
	private String title;
	private String description;
	private String deadline;
	private int priority;
	private boolean isCompleted;
	
	public TodoItem(String title, String description, String deadline, int priority) {
		this.title = title;
		this.description = description;
		this.deadline = deadline;
		this.priority = priority;
		this.isCompleted = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitel(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public boolean isCompleted() {
		return isCompleted;
	}
	
	public void setCompleted(boolean completed) {
		isCompleted = completed;
	}
	
	@Override
	public String toString() {
		return "Title : " + title + "\nDescription : " + description + "\nDeadline : " + deadline + "\nPriority : " + priority + "\nCompleted : " + (isCompleted ? "Yes" : "No") + "\n"; 
	}
}
