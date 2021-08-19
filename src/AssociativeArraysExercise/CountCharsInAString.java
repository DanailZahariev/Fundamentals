import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> letterCount = new LinkedHashMap<>();
        for (int index = 0; index < text.length() ; index++) {
            char currentSymbol = text.charAt(index);
            if (currentSymbol == ' ') {
                continue;
            }
            if (!letterCount.containsKey(currentSymbol)) {
                letterCount.put(currentSymbol, 1);
            }
            else {
                int currentCount = letterCount.get(currentSymbol);
                letterCount.put(currentSymbol, currentCount + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
