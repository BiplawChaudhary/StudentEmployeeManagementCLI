package Interfaces;

import EntityClasses.StudentClass;
import Exceptions.NameNotFoundException;

import java.util.HashMap;

public interface StudentClassService {

    //Add Student to File
//    void addStudent(HashMap<String, StudentClass> masterMap);
    void addStudent();

    //Search Student
    StudentClass searchStudent()throws NameNotFoundException;

    void displaySearchResult();

    //Calculate the Percentage
    void calculatePercentage();

    //Method that displays all the students.
    void displayAllStudent();
}
