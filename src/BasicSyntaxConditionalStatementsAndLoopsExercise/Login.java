import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        StringBuilder password = new StringBuilder();
        for (int position = username.length() - 1; position >= 0; position--) {
            char currentSymbol = username.charAt(position);
            password.append(currentSymbol);
        }
        String enteredPassword = scanner.nextLine();
        int failedAttempts = 0;
        while (!enteredPassword.equals(password.toString())) {
            failedAttempts++;
            if (failedAttempts >= 4) {
                System.out.printf("User %s blocked!", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            enteredPassword = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", username);
    }
}
