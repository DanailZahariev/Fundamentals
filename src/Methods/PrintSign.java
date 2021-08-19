import java.util.Scanner;

public class PrintSign {
    public PrintSign(int number) {
        if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else {
            System.out.printf("The number %d is zero.", number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        new PrintSign(number);
    }
}
