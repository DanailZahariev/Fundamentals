import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToRemove = scanner.nextLine();
        String input = scanner.nextLine();
        while (input.contains(wordToRemove)) {
            input = RemoveOccurence(input, wordToRemove);
        }
        System.out.print(input);
    }

    private static String RemoveOccurence(String text, String wordToRemove) {
        int beginIndex = text.indexOf(wordToRemove);
        int endIndex = wordToRemove.length() + beginIndex;
        String first = text.substring(0, beginIndex);
        String second = text.substring(endIndex);
        return first + second;
    }
}
