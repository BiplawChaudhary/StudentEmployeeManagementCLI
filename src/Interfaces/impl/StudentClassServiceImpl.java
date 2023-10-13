package Interfaces.impl;

import EntityClasses.StudentClass;
import Exceptions.NameNotFoundException;
import Interfaces.SaveToFile;
import Interfaces.StudentClassService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentClassServiceImpl implements StudentClassService {
    Scanner scanner = new Scanner(System.in);

    //Creating an instance of SaveToFile to get the objects
    SaveToFile<StudentClass> saveToFile = new SaveToFileImpl();

    @Override
    public void addStudent(HashMap<String, StudentClass> masterMap) {
        String name, email, address;
        int age, noOfSubjects;

        Double[] obtMarks , fullMarks;

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

        System.out.print("Enter the number of subjects: ");
        noOfSubjects = scanner.nextInt();
        System.out.println("\nEnter the marks for each subject: ");

        //Initializing the arrays:
        obtMarks = new Double[noOfSubjects];
        fullMarks = new Double[noOfSubjects];

        for(int i=0;i<noOfSubjects;i++){
            System.out.println("Subject "+ (i+1) +" : ");
            System.out.print("Enter full marks: ");
            fullMarks[i] = scanner.nextDouble();
            System.out.print("Enter obtained marks: ");
            obtMarks[i] = scanner.nextDouble();
        }
        //consume if anything is left
        scanner.nextLine();

        //Creating the new Student Entity
        StudentClass std= new StudentClass(name, age,email, address, obtMarks, fullMarks);



        //Try to save it to the file
        if(saveToFile.saveObjectToFile(std, StudentClass.class)){
            System.out.println("\nSTUDENT SAVE SUCCESSFUL.");
            masterMap.put(std.getName(), std);
        }else{
            System.out.println("\nSTUDENT SAVE ERROR.");
        }
    }

    @Override
    public StudentClass searchStudent() throws NameNotFoundException {

        //Get the name to be searched.
        System.out.print("Enter a name to search: ");
        String searchKey = scanner.nextLine().trim().toLowerCase();



        //A hash map to receive the data from the file.
        HashMap<String, StudentClass> allData = saveToFile.getObjectsFromFile(StudentClass.class);

        //If the input name is not contains in the file
        if(!allData.containsKey(searchKey)){
            //Throw the exception
            throw new NameNotFoundException("Student not found in file.");
        }

        //Return the data from the searchKey.
//        System.out.println("Search value ins searchfunction" + allData.get(searchKey));
        System.out.println("\nResult: ");
        return allData.get(searchKey);
    }

    @Override
    public void displaySearchResult() {
        //Since it throws NameNotFoundException handling it.
        try{
//            System.out.println("\n Search Result: ");
            System.out.println(searchStudent().getDetails());
        }catch (NameNotFoundException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void calculatePercentage() {
        //Since it throws NameNotFoundException handling it.
        try{
            StudentClass foundStd = searchStudent();

            System.out.println("Percentage of "+ foundStd.getName() +": "+foundStd.getPercentage());

        }catch (NameNotFoundException ex){
            System.out.println(ex);
        }
    }

    //Method to display all the students.
    @Override
    public void displayAllStudent() {

        //A hash map to receive the data from the file.
        HashMap<String, StudentClass> allData = saveToFile.getObjectsFromFile(StudentClass.class);

        //Creating an iterable interface
        Set<Map.Entry<String, StudentClass>> allDataSet = allData.entrySet();

        //Iterating and displaying each data
        for(var each : allDataSet){
            //For each entry in the map get the value which is a StudentClass Object
//            then get the details from there.
            System.out.println(each.getValue().getDetails());
        }
    }
}
