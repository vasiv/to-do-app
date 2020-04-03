package pl.tt.ui;

import pl.tt.BoardManager;
import pl.tt.model.Board;
import pl.tt.model.Task;

import java.util.Optional;
import java.util.Scanner;


public class ConsoleUI {
    private Scanner in;
    private String userName;
    private String taskName;
    private String taskDescription;
    private String targetBoardName;
    private String sourceBoardName;
    private Task task;

    private static final String todoBoardName = "todo";
    private static final String inProgressBoardName = "in progress";
    private static final String doneBoardName = "done";

    Board board1 = new Board(todoBoardName);
    Board board2 = new Board(inProgressBoardName);
    Board board3 = new Board(doneBoardName);

    BoardManager boardManager;

    public ConsoleUI() {
        in = new Scanner(System.in);
        boardManager = new BoardManager();
        sourceBoardName = "";
        targetBoardName = "";
    }

    public void execute() {
        userName = getLineFromUser("username");

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
                    taskName = getLineFromUser("task name");
                    taskDescription = getLineFromUser("task description");

                    task = new Task(userName, taskName, taskDescription);
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
                    sourceBoardName = getLineFromUser("source board");
                    targetBoardName = getLineFromUser("target board");
                    taskName = getLineFromUser("task name");
                    Optional<Board> sourceBoardOptional = getBoardByName(sourceBoardName);
                    if (checkOptionalIfPresent(sourceBoardOptional, "Board", sourceBoardName) == false) {
                        break;
                    }
                    Board sourceBoard = sourceBoardOptional.get();

                    Optional<Board> targetBoardOptional = getBoardByName(targetBoardName);
                    if (checkOptionalIfPresent(targetBoardOptional, "Board", targetBoardName) == false) {
                        break;
                    }
                    Board targetBoard = targetBoardOptional.get();

                    Optional<Task> taskOptional = sourceBoard.getTaskByName(taskName);
                    if (checkOptionalIfPresent(taskOptional, "Task", taskName) == false) {
                        break;
                    }
                    task = taskOptional.get();

                    boardManager.moveTask(sourceBoard, targetBoard, task);
                    break;
            }
        }
    }

    private Optional<Board> getBoardByName(String boardName) {
        switch (boardName) {
            case todoBoardName:
                return Optional.of(board1);
            case inProgressBoardName:
                return Optional.of(board2);
            case doneBoardName:
                return Optional.of(board3);
        }
        return Optional.empty();
    }

    private <T> boolean checkOptionalIfPresent(Optional<T> optional, String resourceName, String name) {
        boolean isPresent = optional.isPresent();
        if (isPresent == false) {
            System.out.println(resourceName + " with name " + name + " not found!");
        }
        return isPresent;
    }

    private String getLineFromUser(String resourceName) {
        System.out.println("Please provide " + resourceName + ": ");
        return in.nextLine();
    }

}
