package org.yourcompany.yourprojectshemanth;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Person> people = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        int choice;
        do {
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Add Admin");
            System.out.println("4. View All People");
            System.out.println("5. Generate Report (Threaded)");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addTeacher();
                case 3 -> addAdmin();
                case 4 -> viewAllPeople();
                case 5 -> generateReport();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option, try again.");
            }
            System.out.println();
        } while (choice != 6);
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        people.add(new Student(id, name, grade));
        System.out.println("Student added successfully.");
    }

    private void addTeacher() {
        System.out.print("Enter Teacher ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Teacher Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Subject: ");
        String subject = scanner.nextLine();

        people.add(new Teacher(id, name, subject));
        System.out.println("Teacher added successfully.");
    }

    private void addAdmin() {
        System.out.print("Enter Admin ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Admin Name: ");
        String name = scanner.nextLine();

        people.add(new Admin(id, name));
        System.out.println("Admin added successfully.");
    }

    private void viewAllPeople() {
        if (people.isEmpty()) {
            System.out.println("No entries to display.");
            return;
        }
        System.out.println("List of People:");
        for (Person p : people) {
            p.displayInfo();
        }
    }

    private void generateReport() {
        ReportGenerator rg = new ReportGenerator(people);
        rg.start();
        try {
            rg.join(); // wait for the report to complete before continuing
        } catch (InterruptedException e) {
            System.out.println("Report generation interrupted.");
        }
    }
}
