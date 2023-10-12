package Interfaces;

import EntityClasses.EmployeeClass;
import EntityClasses.StudentClass;
import Exceptions.NameNotFoundException;

public interface EmployeeClassService {
    //Add Student to File
    void addEmployee();

    //Search Student
    EmployeeClass searchEmployee()throws NameNotFoundException;

    void displaySearchResult();

    //Calculate the Percentage
    void calculatePayableSalary();

    //Method that displays all the students.
    void displayAllEmployees();
}
