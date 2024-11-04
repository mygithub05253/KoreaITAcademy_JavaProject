package Source_code;

import java.util.Scanner;

public class TodoApp {
	
	private static TodoList todoList = new TodoList();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			showMenu();
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
			case 1:
				addTodoItem();
				break;
			case 2:
				updateTodoItem();
				break;
			case 3:
				deleteTodoItem();
				break;
			case 4:
				listTodoItems();
				break;
			case 5:
				markAsCompleted();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice. Please try again.");
			}
		}
	}
	
	private static void showMenu() {
		System.out.println("1. Add To-Do Item");
		System.out.println("2. Update To-Do Item");
		System.out.println("3. Delete To-Do Item");
		System.out.println("4. List To-Do Item");
		System.out.println("5. Mark As Completed");
		System.out.println("0. Exit");
		System.out.print("Choose an option : ");
	}
	
	private static void addTodoItem() {
		System.out.print("Title : ");
		String title = scanner.nextLine();
		System.out.print("Description : ");
		String description = scanner.nextLine();
		System.out.print("Deadline : ");
		String deadline = scanner.nextLine();
		System.out.print("Priority : ");
		int priority = Integer.parseInt(scanner.nextLine());
		
		TodoItem item = new TodoItem(title, description, deadline, priority);
		todoList.addItem(item);
	}
	
	private static void updateTodoItem() {
		listTodoItems();
		System.out.print("Enter the number of the item to update : ");
		int index = Integer.parseInt(scanner.nextLine()) - 1;
		
		if(index >= 0 && index < todoList.getItems().size()) {
			System.out.print("Title : ");
			String title = scanner.nextLine();
			System.out.print("Description : ");
			String description = scanner.nextLine();
			System.out.print("Deadline : ");
			String deadline = scanner.nextLine();
			System.out.print("Priority : ");
			int priority = Integer.parseInt(scanner.nextLine());
			
			TodoItem item = new TodoItem(title, description, deadline, priority);
			todoList.updateItem(index, item);
		} else {
			System.out.println("Invalid item number.");
		}
	}
	
	private static void deleteTodoItem() {
		listTodoItems();
		System.out.print("Enter the number of the item to delete : ");
		int index = Integer.parseInt(scanner.nextLine()) - 1;
		
		if(index >= 0 && index < todoList.getItems().size()) {
			todoList.deleteItem(index);
		} else {
			System.out.println("Invalid item number.");
		}
	}
	
	private static void listTodoItems() {
		int index = 1;
		for(TodoItem item : todoList.getItems()) {
			System.out.println(index + ". " + item);
			index++;
		}
	}
	
	private static void markAsCompleted() {
		listTodoItems();
		System.out.print("Enter the number of the item ot mark as completed : ");
		int index = Integer.parseInt(scanner.nextLine()) - 1;
		if(index >= 0 && index < todoList.getItems().size()) {
			TodoItem item = todoList.getItems().get(index);
			item.setCompleted(true);
			todoList.updateItem(index, item);
		} else {
			System.out.println("Invalid item number.");
		}
	}

}
