import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String regex = "([*@])(?<word>[A-Z][a-z]{2,})(\\1)(: \\[)(?<one>[A-Za-z])(\\]\\|\\[)(?<two>[A-Za-z])(\\]\\|\\[)(?<three>[A-Za-z])(\\]\\|)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String word = matcher.group("word");
                String str1 = matcher.group("one");
                String str2 = matcher.group("two");
                String str3 = matcher.group("three");
                System.out.println(String.format("%s: %s %s %s", word, (int) str1.charAt(0), (int) str2.charAt(0), (int) str3.charAt(0)));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
