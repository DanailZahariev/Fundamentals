import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        for (int row = 0; row < n; row++) {
            String input = scanner.nextLine();
            int firstNum = Integer.parseInt(input.split(" ")[0]);
            int secondNum = Integer.parseInt(input.split(" ")[1]);
            if ((row + 1) % 2 == 0) {
                arrayOne[row] = secondNum;
                arrayTwo[row] = firstNum;
            } else {
                arrayOne[row] = firstNum;
                arrayTwo[row] = secondNum;
            }
        }
        for (int number : arrayOne) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : arrayTwo) {
            System.out.print(number + " ");
        }
    }
}
