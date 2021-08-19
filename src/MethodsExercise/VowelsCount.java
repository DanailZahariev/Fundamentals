import java.util.Locale;
import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        printVowelStrings(input);
    }

    private static void printVowelStrings(String input) {
        int count = 0;
        for (int index = 0; index <= input.length() - 1; index++) {
            char current = input.charAt(index);
            switch (current) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }
        System.out.println(count);
    }
}
