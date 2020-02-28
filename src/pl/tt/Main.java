package pl.tt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Podaj imię: ");
        String userName = input.nextLine();

        Task task = new Task(userName, "zakupy");
        Task task1 = new Task(userName, "sprzątanie", "posprzątaj kuchnię");

        System.out.println(task.toString());
        System.out.println(task1.toString());

        List<Task> toDoTasks = new ArrayList<>();
        System.out.println(toDoTasks.size());
        toDoTasks.add(task);
        toDoTasks.add(task1);
        System.out.println(toDoTasks.size());

        for (Task task3: toDoTasks) {
            System.out.println(task3.toString());
        }

        toDoTasks.forEach(task4 -> {
            System.out.println(task4.toString());
        });
    }
}
