package LoginAndRegistration;

import Models.User;
import java.util.List;
import java.util.Scanner;

public class LoginFeature {

    private Scanner input;
    private List<User> users;
    private User currentUser;

    public LoginFeature(Scanner input, List<User> users) {
        this.input = input;
        this.users = users;
        this.currentUser = null;
    }

    public void run() {
        boolean check = true;
        String defaultUsername = "fizz_";
        String defaultPassword = "1234@RCO";

        while (check) {
            System.out.println("Welcome to the Login feature");
            System.out.print("Enter your username: ");
            String username = input.nextLine();

            System.out.print("Enter your password: ");
            String password = input.nextLine();

            if (username.equals(defaultUsername) && password.equals(defaultPassword)) {
                System.out.println("Welcome, it's great to see you again!");
                currentUser = new User("Default", "User", defaultUsername, defaultPassword);
                check = false;
            } else {
                for (User user : users) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        System.out.println("Welcome, " + user.getName() + " " + user.getSurname() + ", it's great to see you again!");
                        currentUser = user;
                        check = false;
                        break;
                    }
                }
                if (currentUser == null) {
                    System.out.println("Username or password incorrect. Please try again.");
                }
            }
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        currentUser = null;
    }
}
