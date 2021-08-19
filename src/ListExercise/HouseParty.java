import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> guest = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[2].equals("not")) {
                removeGuest(guest, input);
            } else {
                addGuest(guest, input);
            }
        }
        print(guest);
    }

    private static void print(List<String> guest) {
        for (String guests:guest) {
            System.out.println(guests);
        }
    }

    private static void addGuest(List<String> guest, String[] input) {
        if (!guest.contains(input[0])) {
            guest.add(input[0]);
        } else {
            System.out.println(input[0] + " is already in the list!");
        }
    }

    private static void removeGuest(List<String> guest, String[] input) {
        if (!guest.contains(input[0])) {
            System.out.println(input[0] + " is not in the list!");
        } else {
            guest.remove(input[0]);
        }
    }
}
