import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        int blackListCount = 0;
        int lostCount = 0;
        while (!command.equals("Report")) {
            String[] commandArgument = command.split(" ");
            String name = commandArgument[1];
            switch (commandArgument[0]) {
                case "Blacklist":
                    if (names.contains(name)) {
                        blackListCount++;
                    } else if (!names.contains(name)) {
                        break;
                    }
                    System.out.println(name + " was blacklisted.");
                    System.out.println("Blacklisted names: " + blackListCount);
                    break;
                case "Error":
                    int index = Integer.parseInt(name);
                    if (index<0){
                        lostCount++;
                        System.out.println(lostCount);
                        System.out.println(name + " was lost due to an error.");
                    }
                    break;
                case "Change":
                    break;
            }
            command = scanner.nextLine();
        }
    }
}

