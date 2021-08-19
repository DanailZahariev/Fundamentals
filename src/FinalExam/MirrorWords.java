import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([@#])(?<wordOne>[a-zA-Z]{3,})\\1{2}(?<wordTwo>[a-zA-Z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> mirrorWords = new ArrayList<>();
        int count = 0;
        while (matcher.find()) {
            count++;
            String wordOne = matcher.group("wordOne");
            String wordTwo = new StringBuilder(matcher.group("wordTwo")).reverse().toString();
            if (wordOne.equals(wordTwo)) {
                mirrorWords.add(wordOne + " <=> " + matcher.group("wordTwo"));
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }
        if (mirrorWords.isEmpty()) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }
}
