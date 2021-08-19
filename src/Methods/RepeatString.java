import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repeat = Integer.parseInt(scanner.nextLine());
        stringRepeat(input,repeat);
    }

    private static void stringRepeat(String input, int repeat) {
        for (int i = 0; i < repeat; i++) {
            System.out.print(input);
        }
    }
}
