import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberAsString = scanner.nextLine();
        String[] numbersSplit = numberAsString.split(" ");
        int [] numbers = new int[numbersSplit.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersSplit[i]);
        }
        for (int i = 0; i < numbers.length -1 ; i++) {
            for (int j = 0; j < numbers.length -1 ; j++) {
                numbers[j] = numbers[j]+numbers[j+1];
            }
        }
        System.out.println(numbers[0]);
    }
}
