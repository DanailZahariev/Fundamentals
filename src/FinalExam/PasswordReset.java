import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] tokes = input.split("\\s+");
            String commandName = tokes[0];
            switch (commandName) {
                case "TakeOdd":
                    password = getOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokes[1]);
                    int length = Integer.parseInt(tokes[2]);
                    String substringRemove = password.substring(index, index + length);
                    password = password.replaceFirst(substringRemove, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokes[1];
                    String substitute = tokes[2];
                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print("Your password is: " + password);
    }

    private static String getOdd(String password) {
        StringBuilder newPass = new StringBuilder();
        for (int index = 1; index <= password.length() - 1; index += 2) {
            char currentSymbol = password.charAt(index);
            newPass.append(currentSymbol);
        }
        return newPass.toString();
    }
}
