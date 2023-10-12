package Exceptions;

public class InvalidInputType extends Exception{
    String detail;

    public InvalidInputType(String s){
        detail = s;
    }

    public String toString(){
        return detail;
    }
}
