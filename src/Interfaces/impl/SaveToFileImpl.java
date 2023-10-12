package Interfaces.impl;

import EntityClasses.EmployeeClass;
import EntityClasses.StudentClass;
import Interfaces.SaveToFile;
import Interfaces.StudentClassService;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SaveToFileImpl<T> implements SaveToFile<T> {
//    ObjectOutputStream objOut;
    @Override
    public <T> boolean saveObjectToFile(T obj, Class<T> type) {

        //Boolean variable to check if saved.
        boolean saved = false;

        //If it's a student type
        if(type == StudentClass.class){
//            System.out.println("Student Class is passed to svae object to file.");

            //Opening the file with try-with-resources
            try(ObjectOutputStream objOut = new ObjectOutputStream(
                    new FileOutputStream("student.txt", true))){

//                //Creating a seperator
//                objOut.writeObject("***---***");
                //The code to save to file
                objOut.writeObject((StudentClass) obj);
                saved= true;
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }

        //If the passed data is of employee
        else if (type == EmployeeClass.class) {
//            System.out.println("Employee Class is padded to save object to file.");
            //Opening the file with try-with-resources
            try(ObjectOutputStream objOut = new ObjectOutputStream(
                    new FileOutputStream("employee.txt", true))){
//                //Creating a seperator
//                objOut.writeObject("***---***");
                //The code to save to file
                objOut.writeObject((EmployeeClass) obj);
                saved= true;

            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return saved;
    }


    @Override
    public <T> HashMap<String, T> getObjectsFromFile( Class<T> type) {

        HashMap<String, T> returnData= new HashMap<>();


        //If it's a student type
        if(type == StudentClass.class){
//            System.out.println("Student Class is passed to get from object to file.");

            //Using try-with-resources to open the file
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.txt"))){

                //Reading the data from the table.
                StudentClass readStd = (StudentClass) objectInputStream.readObject();
                //Adding the data to hashMap
                returnData.put(readStd.getName(), (T) readStd);


            }catch (IOException | ClassNotFoundException ex){
                System.out.println("Exception occurred while reading student data.");
                ex.printStackTrace();
            }

        }

        //If the passed data is of employee
        else if (type == EmployeeClass.class) {
//            System.out.println("Employee Class is padded to get from object to file.");
            //Using try-with-resources to open the file
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.txt"))){
                //Reading the data from the table.
                EmployeeClass readEmployee = (EmployeeClass) objectInputStream.readObject();

                //Adding the data to hashMap
                returnData.put(readEmployee.getName(), (T) readEmployee);

//                while (true) {
//                    try {
//                        EmployeeClass readEmployee = (EmployeeClass) objectInputStream.readObject();
//                        returnData.put(readEmployee.getName(), (T) readEmployee);
//                    } catch (EOFException e) {
//                        // End of file reached
//                        break;
//                    }
//                }

            }catch (IOException | ClassNotFoundException ex){
                System.out.println("Exception occurred while reading student data.");
                ex.printStackTrace();
            }
        }
        return returnData;
    }
}
