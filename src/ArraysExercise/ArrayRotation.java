import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        int countRotate = Integer.parseInt(scanner.nextLine());
        for (int rotation = 1; rotation <= countRotate; rotation++) {
            String firstElement = numbers[0];
            for (int index = 0; index < numbers.length - 1; index++) {
                numbers[index] = numbers[index + 1];
            }
            numbers[numbers.length - 1] = firstElement;
        }
        System.out.println(String.join(" ", numbers));
    }
}
