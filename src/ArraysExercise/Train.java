import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagon = Integer.parseInt(scanner.nextLine());
        int sumPeople = 0;
        for (int n = 1; n <= wagon; n++) {
            int people = Integer.parseInt(scanner.nextLine());
            System.out.print(people + " ");
            sumPeople += people;
        }
        System.out.println();
        System.out.println(sumPeople);
    }
}
