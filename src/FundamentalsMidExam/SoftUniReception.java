import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacityPerHour = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int students = scanner.nextInt();
        int hours = 0;
        while (students > 0) {
            hours++;
            if (hours % 4 != 0) {
                students-=capacityPerHour;

            }
        }
        System.out.printf("Time needed: %dh.",hours);
    }
}
