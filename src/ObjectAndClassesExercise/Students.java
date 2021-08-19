public class Students {
    public String firstname;
    public String lastName;
    public double grade;

    public Students(String firstname, String lastName, double grade) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s: %.2f", this.firstname, this.lastName, this.grade);
    }
}
