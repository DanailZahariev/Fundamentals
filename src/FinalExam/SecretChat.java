import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Reveal")) {
            String[] tokens = input.split(":\\|:");
            String operation = tokens[0];

            switch (operation) {
                case "InsertSpace": {
                    int index = Integer.parseInt(tokens[1]);
                    message = message.substring(0, index).concat(" ").concat(message.substring(index));
                    System.out.println(message);
                    break;
                }
                case "Reverse": {
                    String substring = tokens[1];
                    StringBuilder newSubstring = new StringBuilder(substring);
                    if (message.contains(substring)) {
                        substring = newSubstring.reverse().toString();
                        int startIndex = message.indexOf(tokens[1]);
                        int endIndex = startIndex + tokens[1].length();
                        StringBuilder updatedString = new StringBuilder(message);
                        updatedString.delete(startIndex, endIndex);
                        message = updatedString.append(substring).toString();
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "ChangeAll": {
                    String substringChange = tokens[1];
                    String replacement = tokens[2];
                    message = message.replace(substringChange, replacement);
                    System.out.println(message);
                    break;
                }
            }
            input = scan.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }
}