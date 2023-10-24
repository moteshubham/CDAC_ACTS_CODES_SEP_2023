package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import core.com.app.Task;
import custom_exceptions.ValidationException;
import enums.Status;

public class TaskHandlingRules {

	public static void checkAvailable(int taskID, List<Task> taskList) throws ValidationException {
		Task checkTask = new Task (taskID);
		if(taskList.contains(checkTask)){
			System.out.println("Task is present. ");
		}
		else {
		throw new ValidationException("Task not Found");
		}
	}

	public static void checkUpdateStatus(int taskID, String stat, List<Task> taskList) throws ValidationException {
		
		 Status statusToUpdate = Status.valueOf(stat.toUpperCase());
		 taskList.get(taskID).setStatusValue(statusToUpdate);
	}

	public static LocalDate parseAndValidateDate(String dated) throws DateTimeParseException {
		return LocalDate.parse(dated);
	}
	public static void deleteTask(int taskID, List<Task> taskList) {
				taskList.get(taskID).setActive(false);
				//taskList.remove(taskID);
	}

	public static Task validateTask(String taskName, String desc, String taskDate)
			throws ValidationException, DateTimeParseException {
		
		LocalDate taskDateVerified = parseAndValidateDate(taskDate);
		Task newTask = new Task(taskName, desc, taskDateVerified );
		return newTask;

	}
}
