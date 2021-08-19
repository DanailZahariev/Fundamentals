import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int num = 1; num <= n; num++) {
            int sumOfDigits = num;
            int sum = 0;
            while (sumOfDigits != 0) {
                int currentDigit = sumOfDigits % 10;
                sum = sum + currentDigit;
                sumOfDigits = sumOfDigits / 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.println(num + " -> True");
            } else {
                System.out.println(num + " -> False");
            }
        }
    }
}
