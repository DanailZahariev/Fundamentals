import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([=/])([A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> destination = new ArrayList<>();
        while (matcher.find()) {
            destination.add(matcher.group(2));
        }
        System.out.println("Destinations: " + String.join(", ",destination));
        System.out.println("Travel Points: " + destination.stream().mapToInt(String::length).sum());
    }
}
