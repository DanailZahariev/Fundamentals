import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOne = Integer.parseInt(scanner.nextLine());
        char charOne = scanner.nextLine().charAt(0);
        int numTwo = Integer.parseInt(scanner.nextLine());
        int operations = getOperations(numOne, charOne, numTwo);
        System.out.println(operations);
    }

    private static int getOperations(int numOne, char charOne, int numTwo) {
        int sum = 0;
        switch (charOne) {
            case '+':
                sum = numOne + numTwo;
                break;
            case '-':
                sum = numOne - numTwo;
                break;
            case '*':
                sum = numOne * numTwo;
                break;
            case '/':
                sum = numOne / numTwo;
                break;
        }
        return sum;
    }
}
