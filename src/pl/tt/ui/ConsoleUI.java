package pl.tt.ui;

import pl.tt.BoardManager;
import pl.tt.model.Board;
import pl.tt.model.Task;
import pl.tt.utils.FileUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;


public class ConsoleUI {

    private static final String USERNAME = "userName";
    private static final String EXIT = "exit";
    private static final String TASK_NAME = "task name";
    private static final String TASK_DESCRIPTION = "task description";
    private static final String EMPTY_STRING = "";
    private static final Path HELP_PATH = Paths.get("help.txt");

    Board sourceBoard;
    Board targetBoard;
    BoardManager boardManager;
    private String targetBoardName;
    private String sourceBoardName;
    private String userName;

    public ConsoleUI() {
        boardManager = new BoardManager();
    }

    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println(getHelp());
        userName = getLineFromUser(USERNAME);
        String userInput = EMPTY_STRING;
        while (!EXIT.equalsIgnoreCase(userInput)) {
            System.out.print("Type command: ");
            userInput = in.nextLine();
            switch (userInput) {
                case "exit":
                    return;
                case "add task":
                    executeAddTaskAction();
                    break;
                case "remove task":
                    executeRemoveTaskAction();
                    break;
                case "show todo":
                    executeShowTodoAction();
                    break;
                case "help":
                    System.out.println(getHelp());
                    break;
                case "show in progress":
                    executeShowInProgressAction();
                    break;
                case "show done":
                    executeShowDoneAction();
                    break;
                case "move task":
                    executeMoveTaskAction();
                    break;
            }
        }
    }

    //needs to be changed to allow to select board - not to enter it's name
    private void executeMoveTaskAction() {
        sourceBoardName = getLineFromUser("source board");
        targetBoardName = getLineFromUser("target board");
        String taskName = getLineFromUser("task name");
        Board sourceBoard = boardManager.getBoard(sourceBoardName);
        Board targetBoard = boardManager.getBoard(targetBoardName);
        Optional<Task> maybeTask = this.sourceBoard.getTask(taskName);
        if (checkOptionalIfPresent(maybeTask, "Task", taskName) == false) {
            return;
        }
        Task task = maybeTask.get();

        boardManager.moveTask(this.sourceBoard, this.targetBoard, task);
    }

    private void executeShowTodoAction() {
        boardManager.getBoard("todo").printTasks();
    }

    private void executeShowInProgressAction() {
        boardManager.getBoard("in progress").printTasks();
    }

    private void executeShowDoneAction() {
        boardManager.getBoard("done").printTasks();
    }

    private void executeAddTaskAction() {
        String taskName = getLineFromUser(TASK_NAME);
        String taskDescription = getLineFromUser(TASK_DESCRIPTION);
        Task task = new Task(userName, taskName, taskDescription);
        boardManager.addTaskToBoard("todo", task);
    }

    private void executeRemoveTaskAction() {
        String nameOfBoardWithTaskToBeRemoved = getLineFromUser("source board");
        String nameOfTaskToBeRemoved = getLineFromUser("task name");
        Board board = boardManager.getBoard(sourceBoardName);
        Optional<Task> maybeTaskToBeRemoved = board.getTask(nameOfTaskToBeRemoved);
        if (checkOptionalIfPresent(maybeTaskToBeRemoved, "Task", nameOfTaskToBeRemoved) == false) {
            return;
        }
        Task task = maybeTaskToBeRemoved.get();
        board.removeTask(task);
    }

    private String getHelp() {
        String helpContent = FileUtils.readFileAsString(HELP_PATH);
        if (helpContent.isEmpty()) {
            helpContent = initializeHelp();
        }
        return helpContent;
    }

    private <T> boolean checkOptionalIfPresent(Optional<T> optional, String resourceName, String name) {
        boolean isPresent = optional.isPresent();
        if (isPresent == false) {
            System.out.println(resourceName + " with name " + name + " not found!");
        }
        return isPresent;
    }

    private String initializeHelp() {
        StringBuilder stringBuilder = new StringBuilder("List of possible commands:");
        stringBuilder.append("exit - terminates program\n");
//        stringBuilder.append("show [" + todoBoardName + "/" + inProgressBoardName + "/" + doneBoardName + "] - shows given board content\n");
        stringBuilder.append("add task - adds task to the given board\n");
        stringBuilder.append("move task - moves task from one board to another\n");
        stringBuilder.append("remove task - removes task from given board\n");

        String helpContent = stringBuilder.toString();
        FileUtils.createFile(HELP_PATH, helpContent);
        return helpContent;
    }

    private String getLineFromUser(String resourceName) {
        System.out.println("Please provide " + resourceName + ": ");
        return new Scanner(System.in).nextLine();
    }

}
