public class OrderByAge {
    private String name;
    String iD;
    private int age;

    public OrderByAge(String name, String iD, int age) {
        this.name = name;
        this.iD = iD;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.name, this.iD, this.age);
    }
}
