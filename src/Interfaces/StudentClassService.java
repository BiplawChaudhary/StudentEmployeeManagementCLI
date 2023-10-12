package Interfaces;

import EntityClasses.StudentClass;

public interface StudentClassService {

    //Add Student to File
    String addStudent();

    //Search Student
    StudentClass searchStudent(String name);

    //Calculate the Percentage
    Double calculatePercentage(Double[] marks);
}
