package pl.tt;

import pl.tt.model.Board;
import pl.tt.model.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BoardManager {

    private Map<String, Board> boards = new HashMap<>();
    private static final String todoBoardName = "todo";
    private static final String inProgressBoardName = "in progress";
    private static final String doneBoardName = "done";

    public BoardManager(){
        boards.put(todoBoardName, new Board(todoBoardName));
        boards.put(inProgressBoardName, new Board(inProgressBoardName));
        boards.put(doneBoardName, new Board(doneBoardName));
    }

    public Board getBoard(String boardName){
        return boards.get(boardName);
    }

    public Board addTaskToBoard(String boardName, Task task){
        Board board = getBoard(boardName);
        board.addTask(task);
        return board;
    }

    public void moveTask(Board source, Board target, Task task) {
        source.removeTask(task);
        target.addTask(task);
    }
}
