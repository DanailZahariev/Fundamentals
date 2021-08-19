import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());
        int numbersTwo = Integer.parseInt(scanner.nextLine());
        int numbersThree = Integer.parseInt(scanner.nextLine());
        printSmallestNumber(numbers, numbersTwo, numbersThree);
    }

    private static void printSmallestNumber(int numbers, int numbersTwo, int numbersThree) {
        if (numbers < numbersTwo && numbers < numbersThree) {
            System.out.println(numbers);
        } else if (numbersTwo < numbers && numbersTwo < numbersThree) {
            System.out.println(numbersTwo);
        } else {
            System.out.println(numbersThree);
        }
    }
}
