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
    }


    @Override
    public <T> HashMap<String, T> getObjectsFromFile( Class<T> type) {
    }
}
