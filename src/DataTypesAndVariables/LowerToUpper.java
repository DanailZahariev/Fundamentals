import java.util.Scanner;

public class LowerToUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char lowerOrUpper = scanner.nextLine().charAt(0);
        if (lowerOrUpper >= 65 && lowerOrUpper <= 90) {
            System.out.println("upper-case");
        } else if (lowerOrUpper >= 97 && lowerOrUpper <= 122) {
            System.out.println("lower-case");
        }
    }
}
