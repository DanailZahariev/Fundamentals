import java.util.*;
import java.util.stream.Collectors;

public class StudentsProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Students> students = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String studentsData = scanner.nextLine();
            String[] splitData = studentsData.split("\\s+");
            String firstName = splitData[0];
            String secondName = splitData[1];
            double grade = Double.parseDouble(splitData[2]);
            Students stud = new Students(firstName, secondName, grade);
            students.add(stud);
        }
        students = students.stream().sorted(Comparator.comparingDouble(Students::getGrade))
                .collect(Collectors.toList());
        Collections.reverse(students);
        for (Students students1 : students) {
            System.out.println(students1.toString());
        }
    }
}
