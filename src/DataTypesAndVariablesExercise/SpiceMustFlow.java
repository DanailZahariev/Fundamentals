import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int yield = 0;
        while (startYield >= 100) {
            days++;
            yield += startYield - 26;
            startYield -= 10;
        }
        System.out.println(days);
        if (days == 0) {
            System.out.println(yield);
        } else {
            System.out.println(yield - 26);
        }
    }
}
