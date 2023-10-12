package EntityClasses;

public class EmployeeClass extends PersonClass{
    protected double salary;

    //Constructor
    public EmployeeClass(String name, int age, String email, String address, Double salary){
        super(name, age, email, address);
        this.salary = salary;
    }

    ///Getter
    public double getSalary(){
        return salary;
    }

    @Override
    public String getDetails() {
        return "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Email: " + email + "\n" +
                "Name: " + address + "\n" +
                "Gross Salary: " + salary + "\n";
    }
}
