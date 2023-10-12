package Interfaces;

public interface SaveToFile<T> {
    <T> boolean saveObjectToFile(T obj, Class<T> type);

   <T> boolean getObjectsFromFile(T obj, Class<T> type);
}
