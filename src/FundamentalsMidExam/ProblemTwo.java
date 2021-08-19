import java.util.Arrays;
import java.util.Scanner;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(", ");

        int blacklistedCount = 0;
        int lostNamesCount = 0;

        while (true){
            String commandLine = scanner.nextLine();

            if(commandLine.contains("Report")){
                break;
            }

            String command = commandLine.split(" ")[0];
            String value = commandLine.split(" ")[1];

            int arrayIndex = 0;
            for (int i = 0; i <  names.length; i++) {
                if(names[i].equals(value)){
                    arrayIndex = i;
                }
            }

            boolean isNameExistst = Arrays.stream(names).anyMatch(value::equals);
            if (isNameExistst && command.contains("Blacklist")) {
                System.out.printf("%s was blacklisted.", value);
                System.out.println();
                names[arrayIndex] = "Blacklisted";
                blacklistedCount++;
            }

            if(!isNameExistst && command.contains("Blacklist")){
                System.out.printf("%s was not found.", value);
                System.out.println();
            }

            if (command.contains("Error")){
                int index = Integer.parseInt(value);
                if(names.length > index && !names[index].contains("Blacklisted") && !names[index].contains("Lost")){
                    System.out.printf("%s was lost due to an error.",names[index]);
                    System.out.println();
                    names[index] = "Lost";
                    lostNamesCount++;
                }
            }

            if (command.equals("Change")){
                int index = Integer.parseInt(value);
                String newName = commandLine.split(" ")[2];
                if(names.length>index){
                    System.out.printf("%s changed his username to %s.",names[index],newName);
                    names[index] = newName;
                    System.out.println();
                }
            }
        }

        System.out.printf("Blacklisted names: %s",blacklistedCount);
        System.out.println();
        System.out.printf("Lost names: %s",lostNamesCount);
        System.out.println();
        System.out.printf ("%s", String.join(" ", names));
        System.out.println();
    }
}