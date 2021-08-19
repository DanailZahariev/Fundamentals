import java.util.Scanner;
import java.util.Locale;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        long factorial1 = calculateFactorial(num1);
        long factorial2 = calculateFactorial(num2);
        double result = factorial1 * 1.0 / factorial2;
        System.out.printf("%.2f", result);
    }

    public static long calculateFactorial(int number) {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
