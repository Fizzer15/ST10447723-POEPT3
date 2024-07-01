package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import LoginAndRegistration.RegistrationFeature;
import Models.User;
import Management.TaskManager;
import LoginAndRegistration.LoginFeature;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        LoginFeature login = new LoginFeature(input, users);
        RegistrationFeature register = new RegistrationFeature(input, users);
        TaskManager taskManager = new TaskManager(input);

        while (true) {
            System.out.println("""
                               Welcome to the system.
                               Please enter:
                               1. for registration
                               2. for login
                               3. to exit""");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> register.run();
                case 2 -> {
                    login.run();
                            
                    if (login.getCurrentUser() != null) { 
                        taskManager.setCurrentUser(login.getCurrentUser());
                        taskManager.taskManagementMenu();
                    }
                }
                case 3 -> System.exit(0);
                default -> System.out.println("Please enter a valid choice.");
            }
        }
    }
}
