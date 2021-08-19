import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double avg = sum/numbers.size();
        List<Integer> aboveAverage = new ArrayList<>();
        for (int integer : numbers) {
            if (integer > avg) {
                aboveAverage.add(integer);
            }
        }
        if (aboveAverage.isEmpty()) {
            System.out.println("No");
        } else {
            Collections.sort(aboveAverage);
            Collections.reverse(aboveAverage);
            for (int i = 0; i < Math.min(aboveAverage.size(),5); i++) {
                System.out.print(aboveAverage.get(i) + " ");
            }
        }
    }
}
