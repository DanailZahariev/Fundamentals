import java.util.Locale;
import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Registration")) {
            String[] tokes = command.split("\\s+");
            String commandLine = tokes[0];
            switch (commandLine) {
                case "Letters":
                    String lowerUpper = tokes[1];
                    if (lowerUpper.equals("Lower")) {
                        username = username.toLowerCase();
                        System.out.println(username);
                    } else {
                        username = username.toUpperCase();
                        System.out.println(username);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokes[1]);
                    int endIndex = Integer.parseInt(tokes[2]);
                    if (startIndex >= 0 && startIndex < username.length() &&
                            endIndex >= 0 && endIndex < username.length()) {
                        StringBuilder substring = new StringBuilder(username);
                        substring = new StringBuilder(substring.substring(startIndex, endIndex + 1));
                        substring.reverse();
                        System.out.println(substring);
                    }
                    break;
                case "Substring":
                    String containsSubstring = tokes[1];
                    if (username.contains(containsSubstring)) {
                        username = username.replaceAll(containsSubstring, "");
                        System.out.println(username);
                    } else {
                        System.out.printf("The username %s doesn't contain %s.%n", username, containsSubstring);
                    }
                    break;
                case "Replace":
                    String charToRemove = tokes[1];
                    if (username.contains(charToRemove)) {
                        username = username.replaceAll(charToRemove, "-");
                        System.out.println(username);
                    }
                    break;
                case "IsValid":
                    String isValidChar = tokes[1];
                    if (username.contains(isValidChar)) {
                        System.out.println("Valid username.");
                    } else {
                        System.out.printf("%s must be contained in your username.%n", isValidChar);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}