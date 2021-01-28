public class Lecturer extends Person {

    private double salary;

    public Lecturer(String title, String firsName, String lastName){
        super(title,firsName,lastName);
        salary = 0.0;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
