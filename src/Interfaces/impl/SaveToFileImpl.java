package Interfaces.impl;

import EntityClasses.EmployeeClass;
import EntityClasses.StudentClass;
import Interfaces.SaveToFile;
import Interfaces.StudentClassService;

public class SaveToFileImpl implements SaveToFile<StudentClass> {

    @Override
    public <T> boolean saveObjectToFile(T obj, Class<T> type) {
        //If it's a student type
        if(type == StudentClass.class){
            System.out.println("Student Class is passed to svae object to file.");
        } else if (type == EmployeeClass.class) {
            System.out.println("Employee Class is padded to save object to file.");
        }
        return true;
    }

    @Override
    public <T> boolean getObjectsFromFile(T obj, Class<T> type) {
        return false;
    }
}
