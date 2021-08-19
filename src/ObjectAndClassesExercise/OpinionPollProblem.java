import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPollProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String personalData = scanner.nextLine();
            String[] splitData = personalData.split("\\s+");
            String name = splitData[0];
            int age = Integer.parseInt(splitData[1]);
            Person person = new Person(name, age);
            people.add(person);
        }
        people = people.stream().filter(person -> person.getAge()>30).collect(Collectors.toList());
        people.sort(Comparator.comparing(Person::getName));
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
