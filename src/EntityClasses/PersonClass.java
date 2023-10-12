package EntityClasses;

import java.io.Serializable;

public abstract class PersonClass implements Serializable {
    //Instance Variables
    protected String name;
    protected int age;
    protected String email;
    protected String address;

    //Constructors
    //Default Class
    public PersonClass(){}
    //
    public PersonClass(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    //Get all the details
    public abstract String getDetails();

    //------Getters and Setters-----

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
