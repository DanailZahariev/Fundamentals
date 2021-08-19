import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> phones = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandArgument = command.split(" - ");
            String phone = commandArgument[1];
            switch (commandArgument[0]) {
                case "Add":
                    if (!phones.contains(phone)) {
                        phones.add(phone);
                    }
                    break;
                case "Remove":
                    if (phones.contains(phone)) {
                        phones.remove(phone);
                    }
                    break;
                case "Bonus phone":
                    String[] bonusPhone = phone.split(":");
                    String oldPhone = bonusPhone[0];
                    String newPhone = bonusPhone[1];
                    if (phones.contains(oldPhone)) {
                        int index = phones.indexOf(oldPhone);
                        phones.add(index+1,newPhone);
                    }
                    break;
                case "Last":
                    if (phones.contains(phone)) {
                        phones.add(phone);
                        phones.remove(phone);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", phones));
    }
}
