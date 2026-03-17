package com.profilemanagement.view;

import com.profilemanagement.controller.UserController;
import com.profilemanagement.model.User;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private final Scanner sc = new Scanner(System.in);
    private final UserController controller = new UserController();

    public void showMenu() {
        System.out.println("\n=== Profile Management System ===");
        System.out.println("1. Add User");
        System.out.println("2. View All Users");
        System.out.println("3. View User By ID");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    public void addUser() {
        sc.nextLine(); // clear buffer
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean result = controller.addUser(name, email, password);
        System.out.println(result ? "User added successfully!" : "Error adding user!");
    }

    public void viewAllUsers() {
        List<User> users = controller.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            for (User u : users) {
                System.out.println(u.getId() + " | " + u.getName() + " | " + u.getEmail());
            }
        }
    }

    public void viewUserById() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        User user = controller.getUserById(id);

        if (user != null) {
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
        } else {
            System.out.println("User not found!");
        }
    }

    public void startProgram() {
        while (true) {
            showMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addUser();
                case 2 -> viewAllUsers();
                case 3 -> viewUserById();
                case 4 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    public static void main(String[] args) {
        new MainView().startProgram();
    }
}
