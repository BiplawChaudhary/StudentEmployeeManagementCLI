import EntityClasses.StudentClass;
import Exceptions.NameNotFoundException;
import Interfaces.EmployeeClassService;
import Interfaces.StudentClassService;
import Interfaces.impl.EmployeeClassServiceImpl;
import Interfaces.impl.StudentClassServiceImpl;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //Creating a scanner class
    static Scanner scanner = new Scanner(System.in);

    //Method that handles the manage student menu
    static void manageStudentMenu(){
        //run
        boolean run= true;
        int choice=3;

        //Creating an instance of the service interface
        StudentClassService studentClassService = new StudentClassServiceImpl();

        HashMap<String, StudentClass> masterHashaMap = new HashMap<>();

        //The Students menu
        do{
            System.out.println("\nSTUDENT MENU");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Calculate Percent");
            System.out.println("4. Display All Students");
            System.out.println("5. GO BACK");

            try{
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Please enter a valid number.");
            }


            switch (choice){
                case 1-> studentClassService.addStudent();
                case 2-> studentClassService.displaySearchResult();
                case 3-> studentClassService.calculatePercentage();
                case 4 -> studentClassService.displayAllStudent();
                case 5-> run=false;
                default -> System.out.println("Please select the correct choice.");
            }


        }while (run);
    }

    //Method that handles the manage employee menu
    static void manageEmployeeMenu(){
        //run
        boolean run= true;
        int choice=3;

        //Creating an instance of employee service
        EmployeeClassService employeeClassService = new EmployeeClassServiceImpl();


        //The Students menu
        do{
            System.out.println("\nEmployee MENU");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Calculate Payable Salary");
            System.out.println("4. Display All Employee");
            System.out.println("5. GO BACK");

            try{
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Please enter a valid number.");
            }

            switch (choice){
                case 1-> employeeClassService.addEmployee();
                case 2-> employeeClassService.displaySearchResult();
                case 3-> employeeClassService.calculatePayableSalary();
                case 4 -> employeeClassService.displayAllEmployees();
                case 5-> run=false;
                default -> System.out.println("Please enter a correct choice.");
            }
        }while (run);
    }

    /// The Main method
    public static void main(String[] args) {

        //Local variables
        boolean run = true;
        int choice=3;


        do{
            System.out.println("\nMENU:");
            System.out.println("1. Manage Student");
            System.out.println("2. Manage Employee");
            System.out.println("3. Exit");

            try{
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Please enter a valid number.");
            }

            //Menu for switch coice
            switch (choice){
                case 1 -> manageStudentMenu();
                case 2 -> manageEmployeeMenu();
                case 3 ->run =false;
                default -> System.out.println("Please select a correct option.");
            }

        }while (run);

    }
}