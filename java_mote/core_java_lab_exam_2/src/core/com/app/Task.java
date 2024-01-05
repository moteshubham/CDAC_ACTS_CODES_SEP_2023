package core.com.app;

import java.time.LocalDate;

import enums.Status;

/*2. Create a menu driven application "TaskManager" to manage your day-to-day tasks. 

You can create a class Task with fields like taskId, taskName, description, taskDate, status, active. 
taskId should be unique and generated automatically.
status should be either PENDING, IN PROGRESS or COMPLETED.
active should be either true or false. Deleted task will have active=false 
Newly added task should have default status as PENDING and active=true

You can use suitable data structure to store data in memory.

Following functionalities are expected -

a. Add New Task                       
b. Delete a task                         
c. Update task status               
d. Display all pending tasks     
e. Display all pending tasks for today           
f.  Display all tasks sorted by taskDate*/

public class Task implements Comparable<Task>{
	private static int taskIDCounter;
	private int taskID;
	private String taskName;
	private String desc;
	private LocalDate taskDate;
	private Status statusValue;
	private boolean active;

	static {
		taskIDCounter = 0;
	}

	public Task(String taskName, String desc, LocalDate taskDate) {
		super();
		this.taskID = ++taskIDCounter;
		this.taskName = taskName;
		this.desc = desc;
		this.taskDate = taskDate;
		this.statusValue = Status.PENDING;
		this.active = true;
	}
	@Override
	public int compareTo(Task toCompare) {
		if(this.taskDate.isAfter(toCompare.taskDate))
			return 1;
		else 
		return -1;
	}
		public Task(int taskID) {
			this.taskID = taskID;
		}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Task) {
			return this.taskID == ((Task) o).taskID;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Task [taskID : " + taskID + ", taskName : " + taskName + ", desc : " + desc + ", taskDate : " + taskDate
				+ ", Status : " + statusValue + ", active : " + active + "]";
	}
	
	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public Status getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(Status statusValue) {
		this.statusValue = statusValue;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}



}
