import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String treasure = scanner.nextLine();
        String[] splitChest = treasure.split("\\|");
        List<String> chestContent = new ArrayList<>(Arrays.asList(splitChest));
        String command = scanner.nextLine();
        while (!"Yohoho!".equals(command)) {
            String[] commandArray = command.split(" ");
            String currentCommand = commandArray[0];
            switch (currentCommand) {
                case "Loot":
                    for (int i = 1; i < commandArray.length; i++) {
                        if (!chestContent.contains(commandArray[i])) {
                            chestContent.add(0, commandArray[i]);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandArray[1]);
                    if (dropIndex < 0 || dropIndex >= chestContent.size()) {
                        break;
                    }
                    chestContent.add(chestContent.remove(dropIndex));
                    break;
                case "Steal":
                    int stealAmount = Integer.parseInt(commandArray[1]);
                    List<String> stolen = new ArrayList<>();
                    String output = "";
                    if (stealAmount >= chestContent.size()) {
                        output = String.join(", ", chestContent);
                        System.out.println(output);
                        chestContent.clear();
                        break;
                    }
                    for (int i = 0; i < stealAmount; i++) {
                        int lastIndex = chestContent.size() - 1;
                        stolen.add(chestContent.remove(lastIndex));
                    }
                    Collections.reverse(stolen);
                    output = String.join(", ", stolen);
                    System.out.println(stolen);
                    break;
            }
            command = scanner.nextLine();
        }
        int totalSize = 0;
        for (String currentLoot : chestContent) {
            totalSize += currentLoot.length();
        }
        if (totalSize == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double average = 1.0 * totalSize / chestContent.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", average);
        }
    }
}
