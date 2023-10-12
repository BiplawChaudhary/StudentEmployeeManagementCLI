package Interfaces;

public interface SaveToFile<T> {
    T saveObjectToFile(T obj);

    T getObjectFromFile(T obj);
}
