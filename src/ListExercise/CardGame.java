import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            if (firstPlayer.get(0).equals(secondPlayer.get(0))) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else if (firstPlayer.get(0) > secondPlayer.get(0)) {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.add(secondPlayer.get(0));
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else if (firstPlayer.get(0) < secondPlayer.get(0)) {
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.add(firstPlayer.get(0));
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }
        int sum = 0;
        if (firstPlayer.size() > 0) {
            for (int player1 : firstPlayer) {
                sum += player1;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (int player2 : secondPlayer) {
                sum += player2;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
