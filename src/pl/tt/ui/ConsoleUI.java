package pl.tt.ui;

import pl.tt.model.Board;
import pl.tt.model.Task;

import java.util.Scanner;

public class ConsoleUI {
    Scanner in;
    String userName;

    Board board1 = new Board("To do");
    Board board2 = new Board("In progress");
    Board board3 = new Board("Done");

    public ConsoleUI() {
        in = new Scanner(System.in);
    }

    public void execute() {
        System.out.print("Type name: ");
        String userName = in.nextLine();
        String userInput = "";
        while (!userInput.equalsIgnoreCase("quit")) {
            System.out.print("Type command: ");
            userInput = in.nextLine();

            switch (userInput) {
                case "exit":
                    return;
                case "quit":
                    break;
                case "add task":
                    System.out.print("Type task name: ");
                    String taskName = in.nextLine();
                    System.out.print("Type task description: ");
                    String taskDescription = in.nextLine();
                    Task task = new Task(userName, taskName, taskDescription);
                    board1.addTask(task);
                    break;
                case "show todo":
                    board1.printTasks();
                    break;
                case "show in progress":
                    board2.printTasks();
                    break;
                case "show done":
                    board3.printTasks();
                    break;
                case "move task":
                    break;
            }
        }
    }

}
