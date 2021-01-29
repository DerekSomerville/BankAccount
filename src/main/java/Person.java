public class Person {

    static final int titleCol = 0;
    static final int firstNameCol = 1;
    static final int lastNameCol = 2;

    private String title;
    private String firstName;
    private String lastName;


    public Person(String title, String firstName, String lastName){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle(){
        return title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(){
        return title + " " + firstName + " " + lastName;
    }

    public String accountName(){
        return title + " " + firstName.substring(0,1) + " " + lastName;
    }
}
