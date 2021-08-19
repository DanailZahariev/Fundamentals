import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#]|[\\|])(?<item>[A-Za-z ]+)\\1" +
                "(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1" +
                "(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(text);
        List<String[]> items = new ArrayList<>();
        int totalCal = 0;
        while (matcher.find()) {
            String item = matcher.group("item");
            String date = matcher.group("date");
            String calories = (matcher.group("calories"));
            totalCal += Integer.parseInt(matcher.group("calories"));
            String[] info = new String[3];
            info[0] = item;
            info[1] = date;
            info[2] = calories;
            items.add(info);
        }
        System.out.printf("You have food to last you for: %d days!%n", totalCal/2000);
        items.forEach(food -> System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", food[0], food[1], food[2]));
    }
}
