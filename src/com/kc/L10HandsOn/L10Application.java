package com.kc.L10HandsOn;

import java.util.ArrayList;
import java.util.Scanner;

public class L10Application {
	
	// list of tasks = arrayList?
	static ArrayList<Task> tasks;
	// read from the console
	static Scanner sc;

	public static void main(String[] args) {

		// initialize my arraylist
		tasks =new ArrayList<Task>();
		//initialize the scanner
		sc = new Scanner(System.in);
		
		tasks.add(new Task("wash the dog"));
		tasks.add(new Task("wash the car"));
		tasks.add(new Task("read programming blog"));
		tasks.add(new Task("upload projects to GitHub"));
		boolean running = true;
		
		do {
			displayMenu();
			int menuChoice = readChoice();
			
			switch(menuChoice) {
			case 1:
				System.out.println("Name of the task to add");
				break;
			case 2:
				listTasks();
				System.out.println("Item to remove:");
				int removeId = readChoice();
				removeTask(removeId);
				break;
				
			case 3:
				listTasks();
				System.out.println("Item to complete:");
				int completeId = readChoice();
				completeTask(completeId);
				break;
			case 4:
				listTasks();
				break;
			case 0:
				running = false;
				break;
				default:
					System.out.println("unknown menu choice");

			}
			
			running = false;
		} while(running);
		
		// loop
		// display menu <- sysout
		// 1: add a task
		// 2: remove a task
		// 3: mark a task as complete
		// 4: list the tasks
		// prompt: user input <- scanner	
		// until user selects 0 for exit
			
	}
	
	public static void displayMenu() {
		System.out.println("--Task Manager--");
		System.out.println("1: add a task");
		System.out.println("2: remove a task");
		System.out.println("3: mark a task complete");
		System.out.println("4: list tasks");
		System.out.println("0: quit");
		System.out.println("Choice: ");
	}

	public static int readChoice() {
		int result = sc.nextInt();
		sc.nextLine();
		return result;
		
	}

	public static void listTasks() {
		System.out.println("--Tasks--");
		for(int i = 0; i < tasks.size(); i++) {
			System.out.println(i+1 +". " + tasks.get(i).toString());
		}
	}



public static void completeTask(int id) {
	tasks.get(id-1).setComplete(true);
}

public static void removeTask(int id) {
	tasks.remove(id-1);	
}

public static void addTask(String name) {
	tasks.add(new Task(name));
}
}