import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] tokens = command.split("\\|");
            String commandName = tokens[0];
            switch (commandName) {
                case "Move":
                    int lettersToMove = Integer.parseInt(tokens[1]);
                    String firstPart = message.substring(0, lettersToMove);
                    String lastPart = message.substring(lettersToMove);
                    message = lastPart.concat(firstPart);
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    String first = message.substring(0,index);
                    String second = message.substring(index);
                    message = first.concat(value).concat(second);
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    message = message.replace(substring,replacement);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
