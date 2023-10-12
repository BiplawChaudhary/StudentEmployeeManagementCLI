public class NameNotFoundException extends Exception{
    String detail;

    public NameNotFoundException(String s){
        detail = s;
    }

    public String toString(){
        return detail;
    }
}
