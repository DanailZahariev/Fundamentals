import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder newInput = new StringBuilder();
        char firstLetter = input.charAt(0);
        newInput.append(firstLetter);
        for (int index = 0; index < input.length(); index++) {
            char currentSymbol = input.charAt(index);
            char lastSymbol = newInput.charAt(newInput.length() - 1);
            if (currentSymbol != lastSymbol) {
                newInput.append(currentSymbol);
            }
        }
        System.out.println(newInput);
    }
}
