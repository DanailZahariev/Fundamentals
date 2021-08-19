import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "Insert":
                    insert(numbers, command);
                    break;
                case "Delete":
                    delete(numbers, command);
            }

            command = scanner.nextLine().split(" ");
        }
        print(numbers);

    }

    private static void print(List<Integer> numbers) {
        numbers.forEach(number -> System.out.print(number + " "));
    }

    private static void insert(List<Integer> numbers, String[] command) {
        numbers.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
    }

    private static void delete(List<Integer> numbers, String[] command) {
        numbers.removeAll(Arrays.asList(Integer.parseInt(command[1])));
    }
}