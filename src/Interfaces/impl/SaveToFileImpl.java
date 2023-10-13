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

            //A list to store the read data
            List<StudentClass> fileData=new ArrayList<>();

            //Check if the student.txt alreay exists
            if(new File("student.txt").exists()){
                //First opening the file to check if the file contains some data.
                try(ObjectInputStream objInp = new ObjectInputStream(new FileInputStream("student.txt"))){
                    //Display the file availabe size
//                    System.out.println("Saved File Size: " + objInp.available());
                    //If file exist, then read the data from the file into a list
                        fileData = (List<StudentClass>) objInp.readObject();
                }catch (IOException ex){
                    ex.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            //Now add the object to the file
            try(ObjectOutputStream objOut =new ObjectOutputStream(new FileOutputStream("student.txt"))){
                //Add the new data to the list
                fileData.add((StudentClass) obj);

                //Then write the list to the file
                objOut.writeObject(fileData);
                //Update the saved status
                saved = true;

            }catch (IOException ex){
                ex.printStackTrace();
            }


        }

        //If the passed data is of employee
        else if (type == EmployeeClass.class) {
//            System.out.println("Employee Class is padded to save object to file.");
            //A list to store the read data
            List<EmployeeClass> fileData = null;

            //Check if the student.txt alreay exists
            if(new File("employee.txt").exists()){
                //First opening the file to check if the file contains some data.
                try(ObjectInputStream objInp = new ObjectInputStream(new FileInputStream("employee.txt"))){
                    //Display the file availabe size
//                    System.out.println("Saved File Size: " + objInp.available());
                    //If file exist, then read the data from the file into a list
                    fileData = (List<EmployeeClass>) objInp.readObject();
                }catch (IOException ex){
                    ex.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else{
                //If the file is not found, then create ane array list to store the data.
                fileData = new ArrayList<>();
            }

            //Now add the object to the file
            try(ObjectOutputStream objOut =new ObjectOutputStream(new FileOutputStream("employee.txt"))){
                //Add the new data to the list
                fileData.add((EmployeeClass) obj);

                //Then write the list to the file
                objOut.writeObject(fileData);
                //Update the saved status
                saved = true;

            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
        return saved;
    }


    @Override
    public <T> HashMap<String, T> getObjectsFromFile( Class<T> type) {

        HashMap<String, T> returnData= null;


        //If it's a student type
        if(type == StudentClass.class){
                List<StudentClass> fileData =null;
                returnData = new HashMap<>();

//            System.out.println("Student Class is passed to get from object to file.");
            //Check if the student.txt alreay exists
            if(new File("student.txt").exists()){
                //First opening the file to check if the file contains some data.
                try(ObjectInputStream objInp = new ObjectInputStream(new FileInputStream("student.txt"))){
                    //Display the file availabe size
//                    System.out.println("Saved File Size: " + objInp.available());
                    //If file exist, then read the data from the file into a list
                    fileData = (List<StudentClass>) objInp.readObject();

                    //Adding each  data to to the hash map for transfer
                    for(var each: fileData){
                        returnData.put(each.getName(),(T) each);
                    }

                }catch (IOException ex){
                    ex.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

//                //Display the list data
//                for(var each: fileData){
//                    System.out.println(each.getDetails());
//                }
            }else{
                System.out.println("NO DATA EXISTS");
            }


        }

        //If the passed data is of employee
        else if (type == EmployeeClass.class) {
//            System.out.println("Employee Class is padded to get from object to file.");
            List<EmployeeClass> fileData =null;
            returnData = new HashMap<>();

//            System.out.println("Student Class is passed to get from object to file.");
            //Check if the student.txt alreay exists
            if(new File("employee.txt").exists()){
                //First opening the file to check if the file contains some data.
                try(ObjectInputStream objInp = new ObjectInputStream(new FileInputStream("employee.txt"))){
                    //Display the file availabe size
//                    System.out.println("Saved File Size: " + objInp.available());
                    //If file exist, then read the data from the file into a list
                    fileData = (List<EmployeeClass>) objInp.readObject();

                    //Adding each  data to to the hash map for transfer
                    for(var each: fileData){
                        returnData.put(each.getName(),(T) each);
                    }

                }catch (IOException ex){
                    ex.printStackTrace();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

//                //Display the list data
//                for(var each: fileData){
//                    System.out.println(each.getDetails());
//                }
            }else{
                System.out.println("NO DATA EXISTS");
            }
        }
        return returnData;
    }
}
