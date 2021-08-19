import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder startDestination = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] commandArray = input.split(":");
            String commandName = commandArray[0];
            switch (commandName) {
                case "Add Stop":
                    int addStopIndex = Integer.parseInt(commandArray[1]);
                    String insertString = commandArray[2];
                    if (addStopIndex >= 0 && addStopIndex < startDestination.length()) {
                        startDestination.insert(addStopIndex, insertString);
                    }
                    System.out.println(startDestination);
                    break;
                case "Remove Stop":
                    int removeStartIndex = Integer.parseInt(commandArray[1]);
                    int removeEndIndex = Integer.parseInt(commandArray[2]);
                    if (removeStartIndex >= 0 && removeStartIndex < startDestination.length() &&
                            removeEndIndex >= 0 && removeEndIndex < startDestination.length()) {
                        startDestination.delete(removeStartIndex, removeEndIndex + 1);
                    }
                    System.out.println(startDestination);
                    break;
                case "Switch":
                    String oldString = commandArray[1];
                    String newString = commandArray[2];
                    String destination = startDestination.toString();
                    destination = destination.replace(oldString, newString);
                    startDestination = new StringBuilder(destination);
                    System.out.println(startDestination);
                    break;
            }

            input = scanner.nextLine();
        }
       // private static boolean validIndex (int index, String text){
    //        return index>=0 && index<text.length();
     //   }
        System.out.println("Ready for world tour! Planned stops: " + startDestination);

    }
}
