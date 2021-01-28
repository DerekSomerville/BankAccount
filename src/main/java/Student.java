public class Student extends Person {

    private double gpa;

    public Student(String title, String firsName, String lastName){
        super(title,firsName,lastName);
        gpa = 0.0;

    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString(){
        return super.toString() + " " + gpa;
    }
}
