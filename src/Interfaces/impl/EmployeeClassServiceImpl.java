package Interfaces.impl;

import EntityClasses.EmployeeClass;
import Exceptions.NameNotFoundException;
import Interfaces.EmployeeClassService;
import Interfaces.SaveToFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//A functional interface
interface Functions{
    Double calculate(double s);
}

public class EmployeeClassServiceImpl implements EmployeeClassService {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void addEmployee() {
        String name, email, address;
        double salary;
        int age;

        //Then continue with the actual input.
        System.out.print("Enter the name: ");
        name = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter the age: ");
        age =scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the email: ");
        email=scanner.nextLine().trim();
        System.out.print("Enter the address: ");
        address = scanner.nextLine().trim();
        System.out.print("Enter the total salary: ");
        salary = scanner.nextDouble();

        //Consume the newline character by double
        scanner.nextLine();

        //Creating an instance of employee
        EmployeeClass emp = new EmployeeClass(name, age, email, address, salary);

        //Creating an instance of save to file
        SaveToFile<EmployeeClass> saveToFile = new SaveToFileImpl<>();

        //Try to save to it file
        if(saveToFile.saveObjectToFile(emp, EmployeeClass.class)){
            System.out.println("\nEMPLOYEE ADDED SUCCESSFULLY.");
        }else{
            System.out.println("\nEMPLOYEE SAVE FAILED.");
        }
    }

    @Override
    public EmployeeClass searchEmployee() throws NameNotFoundException {

        //Creating an instance of save to file
        SaveToFile<EmployeeClass> saveToFile = new SaveToFileImpl<>();

        //Get the name to be searched
        System.out.print("Enter employee name to search: ");
        String searchValue = scanner.nextLine().trim().toLowerCase();

        //Creating a hash map to sotre the objects baed on name.
        HashMap<String, EmployeeClass> allEmployeeData = saveToFile.getObjectsFromFile(EmployeeClass.class);

//        System.out.println("Employee size: "+ allEmployeeData.size());
        //Searching for the name
        if(!allEmployeeData.containsKey(searchValue)){
            throw new NameNotFoundException("Employee not found in file.");
        }
        System.out.println("\nResult: ");
        return allEmployeeData.get(searchValue);
    }

    @Override
    public void displaySearchResult() {
        try{
//            System.out.println("\n Search Result: ");
            System.out.println(searchEmployee().getDetails());
        }catch (NameNotFoundException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void calculatePayableSalary() {
        //Specify the tax
        int tax = 5;

        //Demonstrating the lambda expression
        try{
            //Search for the name
            EmployeeClass foundEmp = searchEmployee();

//            //lambda function to calculate the payable salary
//          Functions payableSalary = (n) -> n - ((tax/100)*n);

            double returnData = foundEmp.getSalary() - (foundEmp.getSalary() * ((double)tax/100));

          //calcaulate and display the salary
            System.out.println("Payable salary after " + tax +"% of taxation: " + returnData);
        }catch(NameNotFoundException ex){
            System.out.println(ex);
        }


    }

    @Override
    public void displayAllEmployees() {

        //Creating an instance of save to file
        SaveToFile<EmployeeClass> saveToFile = new SaveToFileImpl<>();

        //A hasmap to receive the dat from the file.
        HashMap<String, EmployeeClass> allEmployeeData = saveToFile.getObjectsFromFile(EmployeeClass.class);

        //Creating an iterable interface
        Set<Map.Entry<String, EmployeeClass>> allEmployeeSet = allEmployeeData.entrySet();

        //Iterating and displaying the data
        for(var each: allEmployeeSet){
            //For each entry in the map get the value which is a StudentClass Object
//            then get the details from there.
            System.out.println(each.getValue().getDetails());
        }

    }
}
