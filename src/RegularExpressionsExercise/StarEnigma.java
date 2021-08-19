import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> attackPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String encryptedMessage = scanner.nextLine();
            int count = specialMessage(encryptedMessage);
            String decryptMessage = getDecryptMessage(encryptedMessage, count);
            String regex = "@(?<planet>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<attack>[AD])![^@\\-!:>]*->(?<count>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptMessage);
            if (matcher.find()) {
                String planet = matcher.group("planet");
                String attack = matcher.group("attack");
                if (attack.equals("A")) {
                    attackPlanets.add(planet);
                } else if (attack.equals("D")) {
                    destroyedPlanets.add(planet);
                }
            }
        }
        print(attackPlanets, destroyedPlanets);
    }

    private static void print(List<String> attackPlanets, List<String> destroyedPlanets) {
        Collections.sort(attackPlanets);
        Collections.sort(destroyedPlanets);
        System.out.println("Attacked planets: " + attackPlanets.size());
        if (!attackPlanets.isEmpty()) {
            attackPlanets.forEach(p -> System.out.println("-> " + p));
        }
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        if (!destroyedPlanets.isEmpty()) {
            destroyedPlanets.forEach(p -> System.out.println("-> " + p));
        }
    }

    private static String getDecryptMessage(String encryptedMessage, int count) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentSymbol = encryptedMessage.charAt(i);
            decryptedMessage.append((char) (currentSymbol - count));
        }
        return decryptedMessage.toString();
    }

    private static int specialMessage(String encryptedMessage) {
        String lowerCase = encryptedMessage.toLowerCase();
        int count = 0;
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentSymbol = lowerCase.charAt(i);
            if (currentSymbol == 's' || currentSymbol == 'a' || currentSymbol == 't' || currentSymbol == 'r') {
                count++;
            }
        }
        return count;
    }
}
