import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        while (!"end".equals(input)){
            String[] tokes = input.split("\\s+");
            String firstName = tokes[0];
            String lastName = tokes[1];
            int age = Integer.parseInt(tokes[2]);
            String homeTown = tokes[3];
            Student student = new Student(firstName,lastName,age,homeTown);
            students.add(student);

            input=scanner.nextLine();
        }
        String homeTown = scanner.nextLine();
        for (Student student : students) {
            if(student.getHomeTown().equals(homeTown)){
                System.out.println(student);
            }
        }
    }
}