import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());
        int sumOfInt = getSumOfInt(numOne, numTwo);
        System.out.println(getFinalSum(sumOfInt, numThree));
    }

    private static int getSumOfInt(int numOne, int numTwo) {
        return numOne + numTwo;
    }

    private static int getFinalSum(int sumOfInt, int numThree) {
        return sumOfInt - numThree;
    }
}
