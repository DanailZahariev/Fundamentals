import java.util.Scanner;

public class LetterChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] passwords = input.split("\\s+");
        double sum = 0;
        for (String pass : passwords) {
            double currentSum = getCurrentSum(pass);
            sum += currentSum;
        }
        System.out.printf("%.2f", sum);
    }

    private static double getCurrentSum(String pass) {
        char firstLetter = pass.charAt(0);
        char secondLetter = pass.charAt(pass.length() - 1);
        // int number = Integer.parseInt(pass.replace(firstLetter, ' ').replace(secondLetter, ' ').trim());
        StringBuilder password = new StringBuilder(pass);
        double number = Double.parseDouble(password.deleteCharAt(0).deleteCharAt(password.length() - 1).toString());
        // int number1 = Integer.parseInt(pass.substring(1,pass.indexOf(secondLetter)));
        if (Character.isUpperCase(firstLetter)) {
            int positionUpper = (int) firstLetter - 64;
            number = number / positionUpper;
        } else {
            int positionLower = (int) firstLetter - 96;
            number = number * positionLower;
        }
        if (Character.isUpperCase(secondLetter)) {
            int positionUpper = (int) secondLetter - 64;
            number = number - positionUpper;
        } else {
            int positionLower = (int) secondLetter - 96;
            number = number + positionLower;
        }
        return number;
    }
}
