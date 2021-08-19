import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        printMiddleChar(text);
    }

    public static void printMiddleChar(String text) {
        if (text.length() % 2 != 0) {
            int index = text.length() / 2;
            System.out.println(text.charAt(index));
        } else {
            int index = text.length() / 2 - 1;
            int index2 = text.length() / 2;
            System.out.printf("%c%c", text.charAt(index), text.charAt(index2));
        }
    }
}
