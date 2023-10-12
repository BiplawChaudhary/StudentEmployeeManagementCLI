import Interfaces.StudentClassService;
import Interfaces.impl.StudentClassServiceImpl;

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

        //The Students menu
        do{
            System.out.println("\nSTUDENT MENU");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Calculate Percent");
            System.out.println("3. GO BACK");

            try{
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Please enter a valid number.");
            }

            switch (choice){
                case 1-> studentClassService.addStudent();
                case 2-> System.out.println("Search Student");
                case 3-> System.out.println("Calculate Percent");
                case 4-> run=false;
                default -> System.out.println("Please select the correct choice.");
            }
        }while (run);
    }

    //Method that handles the manage employee menu
    static void manageEmployeeMenu(){
        //run
        boolean run= true;
        int choice=3;

        //The Students menu
        do{
            System.out.println("\nEmployee MENU");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Calculate salary after tax: ");
            System.out.println("4. GO BACK");

            try{
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Please enter a valid number.");
            }

            switch (choice){
                case 1-> System.out.println("Add Employee");
                case 2-> System.out.println("Search Employee");
                case 3-> System.out.println("Calculate salary after tax");
                case 4-> run=false;
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