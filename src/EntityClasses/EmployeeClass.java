package EntityClasses;

public class EmployeeClass extends PersonClass{
    protected Double salary;

    //Constructor
    public EmployeeClass(String name, int age, String email, String address, Double salary){
        super(name, age, email, address);
        this.salary = salary;
    }
}
