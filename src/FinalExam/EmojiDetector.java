import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regexEmoji = "(?<separator>[\\\\:*])\\1(?<emoji>[A-Z][a-z]{2,})\\1\\1";
        String regexNumber = "\\d";
        Pattern numberPattern = Pattern.compile(regexNumber);
        Matcher numberMatcher = numberPattern.matcher(input);
        List<Integer> numbersList = new ArrayList<>();
        long coolness = 1;
        while (numberMatcher.find()) {
            coolness *= Integer.parseInt(numberMatcher.group());
            // int number = Integer.parseInt(numberMatcher.group());
            //  numbers.add(number);
        }
        //long coolness = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.printf("Cool threshold: %d%n", coolness);
        Pattern emojiPattern = Pattern.compile(regexEmoji);
        Matcher emojiMatcher = emojiPattern.matcher(input);
        List<String> emojiList = new ArrayList<>();
        int count = 0;
        while (emojiMatcher.find()) {
            count++;
            String separator = emojiMatcher.group("separator");
            String emoji = emojiMatcher.group("emoji");
            if (isEmojiCool(emoji, coolness)) {
                String fullEmoji = separator + separator + emoji + separator + separator;
                emojiList.add(fullEmoji);
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        emojiList.stream().forEach(System.out::println);
    }

    public static boolean isEmojiCool(String emoji, long coolnessCap) {
        long emojiCoolness = 0;
        for (int i = 0; i < emoji.length(); i++) {
            char emojiChar = emoji.charAt(i);
            emojiCoolness += emojiChar;
        }
        return emojiCoolness >= coolnessCap;
    }
}
