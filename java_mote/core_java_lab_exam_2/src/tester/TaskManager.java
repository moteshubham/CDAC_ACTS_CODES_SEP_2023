package tester;

import static utils.TaskHandlingRules.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import core.com.app.Task;
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

public class TaskManager {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Task> taskList = new ArrayList<>();

			boolean exit = false;
			while (!exit) {

				System.out.println("\n1. Add New Task \n" + "2. Delete a task  \n" + "3. Update task status  \n"
						+ "4. Display all pending tasks \n5. Display all pending tasks for today\n6. Display all tasks sorted by taskDate\n7. Display all now\n"
						+ "0.Exit\n");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						sc.nextLine();
						System.out.println("Enter new taskName : ");
						String taskN = sc.nextLine();
						System.out.println("Enter  Description : ");
						String description = sc.nextLine();
						System.out.println("Enter  taskDate : ");
						String dated = sc.nextLine();

						Task validatedTask = validateTask(taskN, description, dated);
						taskList.add(validatedTask);
						break;

					case 2:
						System.out.println("Enter task id to be deleted");
						int taskID = sc.nextInt() - 1;
						checkAvailable(taskID, taskList);
						deleteTask(taskID, taskList);
						break;

					case 3:
						System.out.println("Enter task id status to be updated");
						taskID = sc.nextInt() - 1;
						System.out.println("Enter status : PENDING, IN_PROCESS, COMPLETED;");
						checkUpdateStatus(taskID, sc.next(), taskList);

						break;

					case 4:
						if (taskList != null) {
							for (Task t : taskList) {
								if (t.getStatusValue() == Status.PENDING && t.isActive()) {
									System.out.println(t);
								}
							}
						}
						break;

					case 5:
						if (taskList != null) {
							for (Task t : taskList) {
								if (t.getStatusValue() == Status.PENDING && t.getTaskDate().equals(LocalDate.now())) {
									System.out.println(t);
								}
							}
						}
						break;

					case 6:
						System.out.println("Tasks sorted by date : ");
						Collections.sort(taskList);
						for (Task t : taskList) {
							System.out.println(t);
						}
						break;

					case 7:
						for (Task t : taskList) {
							System.out.println(t);
						}
						break;

					case 0:
						exit = true;
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Pls retry....");
					// to read off all pending i/ps
					sc.nextLine();
				}
			}

		} // sc.close()
		System.out.println("main over....");
	}

}
