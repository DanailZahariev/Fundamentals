public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;

    public Student(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }

    public String getHomeTown() {

        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " is " + this.age + " years old ";
    }
}

