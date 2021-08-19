import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        double[] nums = Arrays.stream(input).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> counts = new TreeMap<>();
        for (double number : nums) {
            if (!counts.containsKey(number)) {
                counts.put(number, 1);
            } else {
                int occurrences = counts.get(number);
                occurrences++;
                counts.put(number, occurrences);
            }
        }
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
