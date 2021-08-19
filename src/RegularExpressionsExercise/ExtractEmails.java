import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(^|\\s)[a-zA-Z0-9]+((\\.|\\-|\\_)[a-zA-Z0-9]+)*\\b\\@[a-z]+((\\-)[a-z]+)*\\.[a-z]+((\\.)[a-z]+)*";
        String emails = scanner.nextLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emails);
        List<String> validEmail = new ArrayList<>();
        while (matcher.find()){
            validEmail.add(matcher.group());
        }
        for (String s : validEmail) {
            System.out.println(s);
        }
    }
}
