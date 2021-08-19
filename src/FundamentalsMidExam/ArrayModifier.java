import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!"end".equals(command[0])) {
            switch (command[0]) {
                case "swap":
                    swap(numbers, command);
                    break;
                case "multiply":
                    multiply(numbers, command);
                    break;
                case "decrease":
                    decrease(numbers, command);
                    break;
            }

            command = scanner.nextLine().split("\\s+");
        }
        System.out.println(print(numbers));
    }

    private static String print(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private static void decrease(List<Integer> numbers, String[] command) {
        for (int i = 0; i < numbers.size(); i++) {
            int element = numbers.get(i) - 1;
            numbers.set(i, element);
        }
    }

    private static void multiply(List<Integer> numbers, String[] command) {
        int multi = numbers.get(Integer.parseInt(command[1])) * numbers.get(Integer.parseInt(command[2]));
        numbers.set(Integer.parseInt(command[1]), multi);
    }

    private static void swap(List<Integer> numbers, String[] command) {
        Collections.swap(numbers, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
    }
}