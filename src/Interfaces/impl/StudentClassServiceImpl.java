package Interfaces.impl;

import EntityClasses.StudentClass;
import Interfaces.SaveToFile;
import Interfaces.StudentClassService;

import java.util.Scanner;

public class StudentClassServiceImpl implements StudentClassService {
    Scanner scanner = new Scanner(System.in);

    @Override
    public String addStudent() {
        String name, email, address;
        int age, noOfSubjects;

        Double[] obtMarks = null, fullMarks=null;


        System.out.println("Enter the name: ");
        name = scanner.nextLine();
        System.out.println("Enter the age: ");
        age =scanner.nextInt();
        System.out.println("Enter the email: ");
        email=scanner.nextLine();
        System.out.println("Enter the address: ");
        address = scanner.nextLine();

        System.out.println("Enter the number of subjects: ");
        noOfSubjects = scanner.nextInt();
        System.out.println("Enter the marks for each subject: ");

        //Initializing the arrays:
        obtMarks = new Double[noOfSubjects];
        fullMarks = new Double[noOfSubjects];

        for(int i=0;i<noOfSubjects;i++){
            System.out.println("Subject "+ (i+1) +" : ");
            System.out.println("Enter full marks: ");
            fullMarks[i] = scanner.nextDouble();
            System.out.println("Enter obtained marks: ");
            obtMarks[i] = scanner.nextDouble();
        }

        //Creating the new Student Entity
        StudentClass std= new StudentClass(name, age,email, address, obtMarks, fullMarks);

        //Save the entity to database.
        SaveToFile<StudentClass> saveToFile1 = new SaveToFileImpl();
        saveToFile1.saveObjectToFile(std, StudentClass.class);

        return "Student Added Successfully.";
    }

    @Override
    public StudentClass searchStudent(String name) {
        return null;
    }

    @Override
    public Double calculatePercentage(Double[] marks) {
//        Double obt=0.0, full=0.0;
//
//        for(int i=0;i<obtainedMarks.length;i++){
//            obt += obtainedMarks[i];
//            full += fullMarks[i];
//        }
//        return (obt/full) *100;
        return null;
    }
}
