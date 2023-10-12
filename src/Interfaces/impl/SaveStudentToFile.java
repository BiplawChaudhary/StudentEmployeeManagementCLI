package Interfaces.impl;

import EntityClasses.StudentClass;
import Interfaces.SaveToFile;

public class SaveStudentToFile implements SaveToFile<StudentClass> {
    @Override
    public StudentClass saveObjectToFile(StudentClass obj) {
        return null;
    }

    @Override
    public StudentClass getObjectFromFile(StudentClass obj) {
        return null;
    }
}
