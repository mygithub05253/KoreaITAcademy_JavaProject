package Source_Code;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
	private List<TodoItem> items;
	private static final String FILE_NAME = "todolist.dat";
	
	public TodoList() {
		items = new ArrayList<>();
		loadItems();
	}
	
	public void addItem(TodoItem item) {
		items.add(item);
		saveItems();
	}
	
	public void updateItem(int index, TodoItem item) {
		if(index >= 0 && index < items.size()) {
			items.set(index, item);
			saveItems();
		}
	}
	
	public void deleteItem(int index) {
		if(index >= 0 && index < items.size()) {
			items.remove(index);
			saveItems();
		}
	}
	
	public List<TodoItem> getItems() {
		return items;
	}
	
	public void saveItems() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(items);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadItems() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			items = (List<TodoItem>)ois.readObject();
		} catch(IOException | ClassNotFoundException e) {
			items = new ArrayList<>();
		}
	}
}
