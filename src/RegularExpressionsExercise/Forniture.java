import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Forniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furniture>\\w+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        List<String> furnitureList = new ArrayList<>();
        double total = 0;
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String furniture = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furnitureList.add(furniture);
                total += price * quantity;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitureList.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", total);
    }
}
