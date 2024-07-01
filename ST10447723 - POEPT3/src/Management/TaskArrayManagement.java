package Management;

import Models.Task;
import java.util.List;

public class TaskArrayManagement {

    private List<Task> tasks;

    public TaskArrayManagement(List<Task> tasks) {
        this.tasks = tasks;
    }
    
    public void createAspectArrays() {
        try {
            String[][] taskArray = convertTasksToArray();
            String[] developers = new String[tasks.size()];
            String[] taskNames = new String[tasks.size()];
            String[] taskIDs = new String[tasks.size()];
            String[] durations = new String[tasks.size()];
            String[] statuses = new String[tasks.size()];

            for (int i = 0; i < tasks.size(); i++) {
                developers[i] = taskArray[i][0];
                taskNames[i] = taskArray[i][1];
                taskIDs[i] = taskArray[i][2];
                durations[i] = taskArray[i][3];
                statuses[i] = taskArray[i][4];
            }

            System.out.println("Developers: " + java.util.Arrays.toString(developers));
            System.out.println("Task Names: " + java.util.Arrays.toString(taskNames));
            System.out.println("Task IDs: " + java.util.Arrays.toString(taskIDs));
            System.out.println("Durations: " + java.util.Arrays.toString(durations));
            System.out.println("Statuses: " + java.util.Arrays.toString(statuses));
        } catch (Exception e) {
            System.out.println("An error occurred while creating aspect arrays: " + e.getMessage());
        }
    }

    public String[][] convertTasksToArray() {
        try {
            String[][] taskArray = new String[tasks.size()][5];
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                taskArray[i][0] = task.getDeveloper();
                taskArray[i][1] = task.getTaskName();
                taskArray[i][2] = task.getTaskID();
                taskArray[i][3] = String.valueOf(task.getDuration());
                taskArray[i][4] = task.getStatus();
            }
            return taskArray;
        } catch (Exception e) {
            System.out.println("An error occurred while converting tasks to array: " + e.getMessage());
            return new String[0][0];
        }
    }

    public void displayTaskArrays() {
        try {
            String[][] taskArray = convertTasksToArray();
            if (taskArray.length == 0) {
                System.out.println("No tasks available.");
            } else {
                System.out.println("Displaying all tasks (array)");
                System.out.println("---------------------------------------------------");
                System.out.println("Developer | Task Name | Task ID | Duration | Status");
                System.out.println("---------------------------------------------------");
                for (String[] row : taskArray) {
                    System.out.println(row[0] + " | " + row[1] + " | " + row[2] + " | " + row[3] + " | " + row[4]);
                }
                System.out.println("---------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while displaying task arrays: " + e.getMessage());
        }
    }

    public void displayDoneTasks() {
        try {
            String[][] taskArray = convertTasksToArray();
            String[][] doneTasksArray = filterTasksByStatus(taskArray, "Done");

            if (doneTasksArray.length == 0) {
                System.out.println("No tasks with status 'Done'.");
            } else {
                System.out.println("Displaying completed tasks");
                System.out.println("---------------------------------------------------");
                System.out.println("Developer | Task Name | Task ID | Duration | Status");
                System.out.println("---------------------------------------------------");
                for (String[] row : doneTasksArray) {
                    System.out.println(row[0] + " | " + row[1] + " | " + row[2] + " | " + row[3] + " | " + row[4]);
                }
                System.out.println("---------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while displaying done tasks: " + e.getMessage());
        }
    }

    public void displayTaskWithLongestDuration() {
        try {
            String[][] taskArray = convertTasksToArray();
            String[] longestDurationTask = findTaskWithLongestDuration(taskArray);

            if (longestDurationTask == null) {
                System.out.println("No tasks available.");
            } else {
                System.out.println("Showing task with longest duration");
                System.out.println("---------------------------------------------------");
                System.out.println("Developer | Task Name | Task ID | Duration | Status");
                System.out.println("---------------------------------------------------");
                System.out.println(longestDurationTask[0] + " | "
                        + longestDurationTask[1] + " | "
                        + longestDurationTask[2] + " | "
                        + longestDurationTask[3] + " | "
                        + longestDurationTask[4]);
                System.out.println("---------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while displaying the task with the longest duration: " + e.getMessage());
        }
    }

    public void searchTaskByName(String taskName) {
        try {
            String[][] taskArray = convertTasksToArray();
            String[][] matchingTasks = filterTasksByName(taskArray, taskName);

            if (matchingTasks.length == 0) {
                System.out.println("No tasks found with the name: " + taskName);
            } else {
                System.out.println("Displaying task found");
                System.out.println("------------------------------");
                System.out.println("Task Name | Developer | Status");
                System.out.println("------------------------------");
                for (String[] row : matchingTasks) {
                    System.out.println(row[1] + " | " + row[0] + " | " + row[4]);
                }
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while searching for the task by name: " + e.getMessage());
        }
    }

    public void searchTaskByDeveloper(String developer) {
        try {
            String[][] taskArray = convertTasksToArray();
            String[][] matchingTasks = filterTasksByDeveloper(taskArray, developer);

            if (matchingTasks.length == 0) {
                System.out.println("No tasks found for the developer: " + developer);
            } else {
                System.out.println("Showing tasks by " + developer);
                System.out.println("---------------------------------------------------");
                System.out.println("Developer | Task Name | Task ID | Duration | Status");
                System.out.println("---------------------------------------------------");
                for (String[] row : matchingTasks) {
                    System.out.println(row[0] + " | " + row[1] + " | " + row[2] + " | " + row[3] + " | " + row[4]);
                }
            }
        } catch (Exception e) {
            System.out.println("please search for developer");
        }
    }

    public boolean deleteTaskByName(String taskName) {
        try {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getTaskName().equalsIgnoreCase(taskName)) {
                    tasks.remove(i);
                    System.out.println("Task '" + taskName + "' has been deleted.");
                    return true;
                }
            }
            System.out.println("Task '" + taskName + "' not found.");
            return false;
        } catch (Exception e) {
            System.out.println("could not locate task to delete");
            return false;
        }
    }

    private String[][] filterTasksByDeveloper(String[][] taskArray, String developer) {
        try {
            return java.util.Arrays.stream(taskArray)
                    .filter(row -> developer.equalsIgnoreCase(row[0]))
                    .toArray(String[][]::new);
        } catch (Exception e) {
            System.out.println("An error occurred while filtering tasks by developer: " + e.getMessage());
            return new String[0][0];
        }
    }

    private String[][] filterTasksByStatus(String[][] taskArray, String status) {
        try {
            return java.util.Arrays.stream(taskArray)
                    .filter(row -> status.equalsIgnoreCase(row[4]))
                    .toArray(String[][]::new);
        } catch (Exception e) {
            System.out.println("An error occurred while filtering tasks by status: " + e.getMessage());
            return new String[0][0];
        }
    }

    private String[] findTaskWithLongestDuration(String[][] taskArray) {
        try {
            return java.util.Arrays.stream(taskArray)
                    .max((row1, row2) -> Double.compare(Double.parseDouble(row1[3]), Double.parseDouble(row2[3])))
                    .orElse(null);
        } catch (Exception e) {
            System.out.println("An error occurred while finding the task with the longest duration: " + e.getMessage());
            return null;
        }
    }

    private String[][] filterTasksByName(String[][] taskArray, String taskName) {
        try {
            return java.util.Arrays.stream(taskArray)
                    .filter(row -> taskName.equalsIgnoreCase(row[1]))
                    .toArray(String[][]::new);
        } catch (Exception e) {
            System.out.println("An error occurred while filtering tasks by name: " + e.getMessage());
            return new String[0][0];
        }
    }
}
