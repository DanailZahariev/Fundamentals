import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysOfPlunder = scanner.nextInt();
        int dailyPlunder = scanner.nextInt();
        double expectedPlunder = scanner.nextDouble();
        double currentPlunder = 0;
        for (int i = 1; i <= daysOfPlunder; i++) {
            currentPlunder += dailyPlunder;
            if (i % 3 == 0) {
                currentPlunder += 0.5 * dailyPlunder;
            }
            if (i % 5 == 0) {
                currentPlunder = 0.7 * currentPlunder;
            }
        }
        if (currentPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", currentPlunder);
        } else {
            double percentagePlunder = currentPlunder / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentagePlunder);
        }
    }
}
