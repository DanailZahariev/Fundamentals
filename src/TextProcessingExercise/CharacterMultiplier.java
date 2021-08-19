import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String one = input.split(" ")[0];
        String two = input.split(" ")[1];
        if (one.length() > two.length()) {
            System.out.println(calculation(one, two));
        } else {
            System.out.println(calculation(two, one));
        }
    }

    private static int calculation(String one, String two) {
        int sum = 0;
        for (int i = 0; i < two.length(); i++) {
            sum += one.charAt(i) * two.charAt(i);
        }
        for (int i = two.length(); i < one.length(); i++) {
            sum += one.charAt(i);
        }
        return sum;
    }
}
