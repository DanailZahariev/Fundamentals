import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        for (String word : words) {
            String repeat = repeatWord(word, word.length());
            System.out.print(repeat);
        }
    }

    private static String repeatWord(String word, int repeating) {
        String result = "";
        for (int i = 0; i < repeating; i++) {
            result += word;
        }
        return result;
    }
}
