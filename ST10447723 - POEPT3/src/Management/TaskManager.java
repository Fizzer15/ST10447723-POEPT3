package Management;

import Models.Task;
import Models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    private List<Task> tasks;
    private Scanner input;
    private User currentUser;
    private int taskLimit;

    public TaskManager(Scanner input) {
        this.tasks = new ArrayList<>();
        this.input = input;
        this.currentUser = null;
        this.taskLimit = -1;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setTaskLimit() {
        System.out.print("Enter the number of tasks you would like to add: ");
        this.taskLimit = input.nextInt();
        input.nextLine();
    }

    public void addTask() {
        if (currentUser == null) {
            System.out.println("You must be logged in to add a task.");
            return;
        }

        if (taskLimit == -1) {
            setTaskLimit();
        }

        if (tasks.size() >= taskLimit) {
            System.out.println("Task limit reached. You cannot add more tasks.");
            return;
        }

        System.out.print("Enter Task Name: ");
        String taskName = input.nextLine();

        System.out.print("Enter Task Description (max 50 characters): ");
        String taskDescription = input.nextLine();
        while (taskDescription.length() > 50) {
            System.out.println("Task Description is too long. Please enter up to 50 characters.");
            taskDescription = input.nextLine();
        }

        System.out.print("Enter Developer Name: ");
        String developer = input.nextLine();

        double duration = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter Duration In Hours: ");
                duration = Double.parseDouble(input.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Duration should be a number in hours.");
            }
        }

        System.out.print("Enter Status (1: To Do, 2: In Progress, 3: Done): ");
        int statusOption = input.nextInt();
        input.nextLine();
        String status = getStatusFromOption(statusOption);

        int taskNumber = tasks.size() + 1;
        String taskID = generateTaskID(taskName, taskNumber, developer);

        Task newTask = new Task(taskName, taskNumber, taskDescription, developer, duration, taskID, status);
        tasks.add(newTask);

        System.out.println("Task added successfully!");
    }

    private String getStatusFromOption(int option) {
        return switch (option) {
            case 1 ->
                "To Do";
            case 2 ->
                "In Progress";
            case 3 ->
                "Done";
            default ->
                "Unknown";
        };
    }

    private String generateTaskID(String taskName, int taskNumber, String developer) {
        String taskNamePart = taskName.length() >= 2 ? taskName.substring(0, 2) : taskName;
        String developerPart = developer.length() >= 3 ? developer.substring(developer.length() - 3) : developer;
        return taskNamePart.toUpperCase() + ":" + taskNumber + ":" + developerPart.toUpperCase();
    }

    public void displayTasks() {
        if (currentUser == null) {
            System.out.println("You must be logged in to view tasks.");
            return;
        }

        if (tasks.isEmpty()) {
            System.out.println("\nno tasks in system \n");
        } else {
            for (Task task : tasks) {
                System.out.println("-------------");
                System.out.println("Task ID: " + task.getTaskID());
                System.out.println("Task Name: " + task.getTaskName());
                System.out.println("Task Number: " + task.getTaskNumber());
                System.out.println("Task Description: " + task.getTaskDescription());
                System.out.println("Developer: " + task.getDeveloper());
                System.out.println("Duration: " + task.getDuration());
                System.out.println("Status: " + task.getStatus());
                System.out.println("------------");
            }
        }

    }

    public void displayTotalDuration() {
        if (currentUser == null) {
            System.out.println("You must be logged in to view the total duration.");
            return;
        }

        double totalDuration = tasks.stream().mapToDouble(Task::getDuration).sum();
        System.out.println("Total duration of all tasks: " + totalDuration + " hours");
    }

    public void taskManagementMenu() {
        TaskArrayManagement taskArrayManagement = new TaskArrayManagement(tasks);
        while (true) {
            System.out.println("""
                               Please enter:
                               1. to add a task
                               2. to view tasks
                               3. show reports
                               4. show total task duration
                               5. show completed task
                               6. show task with longest duration
                               7. search task by name
                               8. to search task by developer
                               9. delete task
                               10. show all arrays (aspect arrays)
                               0. to logout and go back to main menu""");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    addTask();
                }
                case 2 -> {
                    displayTasks();
                }
                case 3 -> {
                    taskArrayManagement.displayTaskArrays();
                }
                case 4 -> {
                    displayTotalDuration();
                }
                case 5 -> {
                    taskArrayManagement.displayDoneTasks();
                }
                case 6 -> {
                    taskArrayManagement.displayTaskWithLongestDuration();
                }
                case 7 -> {
                    System.out.print("Enter Task Name to search: ");
                    String taskName = input.nextLine();
                    taskArrayManagement.searchTaskByName(taskName);
                }
                case 8 -> {
                    System.out.print("Enter Developer Name to search: ");
                    String developer = input.nextLine();
                    taskArrayManagement.searchTaskByDeveloper(developer);
                }
                case 9 -> {
                    System.out.print("Enter Task Name to delete: ");
                    String taskName = input.nextLine();
                    taskArrayManagement.deleteTaskByName(taskName);
                }
                case 10 -> {
                    System.out.println("showing all arrays (aspect arrays)");
                    taskArrayManagement.createAspectArrays();
                }
                case 0 -> {
                    setCurrentUser(null);
                    System.out.println("Logged out successfully.");
                    return;
                }
                default ->
                    System.out.println("Please enter a valid choice.");
            }
        }
    }

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        TaskManager taskManager = new TaskManager(input);
//        while (true) {
//            System.out.println("Please choose an option:");
//            System.out.println("1. Add Task");
//            System.out.println("2. Display Tasks");
//            System.out.println("3. Exit");
//            int choice = input.nextInt();
//            input.nextLine();
//
//            switch (choice) {
//                case 1 ->
//                    taskManager.addTask();
//                case 2 ->
//                    taskManager.displayTasks();
//                case 3 -> {
//                    System.out.println("Exiting program.");
//                    return;
//                }
//                default ->
//                    System.out.println("Please choose a valid option.");
//            }
//        }
//    }
}
