package EntityClasses;

public class StudentClass extends PersonClass{
    //Instance Variables
    protected Double[] obtainedMarks;
    protected Double[] fullMarks;

    //Constructor
    public StudentClass(String name,int age, String email, String address, Double[] obtMarks, Double[] fullMarks){
        super(name, age, email, address);
        obtainedMarks = obtMarks;
        this.fullMarks = fullMarks;
    }

    //Calculate the percentage
    Double getPercentage(){
        Double obt=0.0, full=0.0;

        for(int i=0;i<obtainedMarks.length;i++){
            obt += obtainedMarks[i];
            full += fullMarks[i];
        }
        return (obt/full) *100;
    }
}
