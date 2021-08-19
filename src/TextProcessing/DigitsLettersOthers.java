import java.util.Scanner;

public class DigitsLettersOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder symbol = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                digits.append(currentSymbol);
            } else if (Character.isLetter(currentSymbol)) {
                letters.append(currentSymbol);
            } else {
                symbol.append(currentSymbol);
            }
        }
        System.out.printf("%s%n%s%n%s%n", digits, letters, symbol);
    }
}
