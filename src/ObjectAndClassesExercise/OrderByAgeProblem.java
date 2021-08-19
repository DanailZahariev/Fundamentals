import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAgeProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<OrderByAge> people = new ArrayList<>();
        while (true) {
            String personalData = scanner.nextLine();
            if (personalData.equals("End")) {
                break;
            }
            String[] splitData = personalData.split("\\s+");
            String name = splitData[0];
            String id = splitData[1];
            int age = Integer.parseInt(splitData[2]);
            OrderByAge person = new OrderByAge(name, id, age);
            people.add(person);
        }
        people.sort(Comparator.comparing(OrderByAge::getAge));
        for (OrderByAge person : people) {
            System.out.println(person.toString());
        }
    }
}
