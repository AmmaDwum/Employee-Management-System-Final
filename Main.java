import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Record Attendance");
            System.out.println("4. View Attendance");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                try {
                    FileWriter writer = new FileWriter("employees.txt", true);

                    System.out.print("Enter employee name: ");
                    String name = input.nextLine();

                    System.out.print("Enter role (Manager / HR / Employee): ");
                    String role = input.nextLine();

                    System.out.print("Enter department: ");
                    String department = input.nextLine();

                    writer.write(name + ", " + role + ", " + department + "\n");
                    writer.close();

                    System.out.println("Employee saved.");
                } catch (Exception e) {
                    System.out.println("Error saving employee.");
                }
            }

            if (choice == 2) {
                try {
                    Scanner fileScanner = new Scanner(new File("employees.txt"));

                    System.out.println("\nEmployee List:");
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }

                    fileScanner.close();
                } catch (Exception e) {
                    System.out.println("No employees found.");
                }
            }

            if (choice == 3) {
                try {
                    FileWriter writer = new FileWriter("attendance.txt", true);

                    System.out.print("Enter employee name: ");
                    String name = input.nextLine();

                    System.out.println("1. Clock In");
                    System.out.println("2. Clock Out");
                    System.out.print("Choose: ");
                    int status = input.nextInt();
                    input.nextLine();

                    if (status == 1) {
                        writer.write(name + " Clocked In\n");
                    }

                    if (status == 2) {
                        writer.write(name + " Clocked Out\n");
                    }

                    writer.close();
                    System.out.println("Attendance recorded.");
                } catch (Exception e) {
                    System.out.println("Error recording attendance.");
                }
            }

            if (choice == 4) {
                try {
                    Scanner fileScanner = new Scanner(new File("attendance.txt"));

                    System.out.println("\nAttendance Records:");
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }

                    fileScanner.close();
                } catch (Exception e) {
                    System.out.println("No attendance records.");
                }
            }

            if (choice == 5) {
                System.out.println("Program ended.");
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}