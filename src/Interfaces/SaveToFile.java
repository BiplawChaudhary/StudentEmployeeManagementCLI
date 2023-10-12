package Interfaces;

import java.util.HashMap;
import java.util.List;

public interface SaveToFile<T> {
    <T> boolean saveObjectToFile(T obj, Class<T> type);

   <T> HashMap<String, T> getObjectsFromFile( Class<T> type);
}
