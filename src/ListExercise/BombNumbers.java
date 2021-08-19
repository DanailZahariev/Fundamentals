import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String[] bomb = scanner.nextLine().split("\\s+");
        int bombNumber = Integer.parseInt(bomb[0]);
        int power = Integer.parseInt(bomb[1]);
        for (int index = 0; index <= numbers.size() - 1; index++) {
            int startIndex = 0;
            int finishIndex = 0;
            if (bombNumber == numbers.get(index)) {
                startIndex = index - power;
                if (startIndex < 0) {
                    startIndex = 0;
                }
                finishIndex = index + power + 1;
                if (finishIndex > numbers.size()) {
                    finishIndex = numbers.size();
                }
                for (int i = startIndex; i < finishIndex; i++) {
                    numbers.remove(startIndex);
                }
                index = 0;
            }
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}