import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double micePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        int countHeadset = lostGames / 2;
        int countMice = lostGames / 3;
        int countKeyboard = lostGames / 6;
        int countMonitor = lostGames / 12;
        double expenses = (countHeadset * headsetPrice) +
                (countMice * micePrice) +
                (countKeyboard * keyboardPrice) + (
                countMonitor * displayPrice);
        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
