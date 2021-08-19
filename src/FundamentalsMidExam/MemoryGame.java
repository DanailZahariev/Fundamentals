import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> sequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        int count = 0;
        while (!input.equals("end")) {
            count++;
            int[] userInput = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int firstIndex = userInput[0];
            int secondIndex = userInput[1];
            if (userIsCheating(firstIndex, secondIndex, sequence)) {
                System.out.println("Invalid input! Adding additional elements to the board");
                String penalty = String.format("-%da", count);
                sequence.add(sequence.size() / 2, penalty);
                sequence.add(sequence.size() / 2, penalty);
                input = scanner.nextLine();
                continue;
            }
            String firstNumber = sequence.get(firstIndex);
            String secondNumber = sequence.get(secondIndex);
            if (firstNumber.equals(secondNumber)) {
                sequence.remove(firstNumber);
                sequence.remove(secondNumber);
                System.out.printf("Congrats! You have found matching elements - %s!%n", firstNumber);
            } else {
                System.out.println("Try again!");
            }
            if (sequence.size() == 0) {
                break;
            }

            input = scanner.nextLine();
        }
        if (sequence.isEmpty()) {
            System.out.printf("You have won in %d turns!", count);
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", sequence));
        }
    }

    private static boolean userIsCheating(int firstIndex, int secondIndex, List<String> sequence) {
        if (firstIndex == secondIndex) {
            return true;
        }
        if (firstIndex < 0 || firstIndex >= sequence.size()) {
            return true;
        }
        if (secondIndex < 0 || secondIndex >= sequence.size()) {
            return true;
        }
        return false;
    }
}
