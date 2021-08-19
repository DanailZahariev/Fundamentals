import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(value -> Integer.parseInt(value)).toArray();
        String[] secondInput = scanner.nextLine().split(" ");
        int[] secondArray = new int[secondInput.length];
        for (int i = 0; i < secondInput.length; i++) {
            secondArray[i] = Integer.parseInt(secondInput[i]);
        }
        int sum = 0;
        boolean identical = true;
        for (int i = 0; i < secondArray.length; i++) {
            sum += firstArray[i];
            if (firstArray[i] != secondArray[i]) {
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                identical = false;
                break;
            }
        }
        if (identical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}

