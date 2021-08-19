import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> composers = new LinkedHashMap<>();
        Map<String, String> keyNote = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];
            composers.put(piece, composer);
            keyNote.put(piece, key);

        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commands = command.split("\\|");
            String commandName = commands[0];
            String piece = commands[1];
            switch (commandName) {
                case "Add":
                    String composer = commands[2];
                    String key = commands[3];
                    if (composers.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        composers.put(piece, composer);
                        keyNote.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                case "Remove":
                    if (composers.containsKey(piece)) {
                        composers.remove(piece);
                        keyNote.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    String newKey = commands[2];
                    if (keyNote.containsKey(piece)) {
                        keyNote.put(piece, newKey);
                        System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        composers.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(
                comp -> {
                    String name = comp.getKey();
                    String piece = comp.getValue();
                    String key = keyNote.get(name);
                    System.out.printf("%s -> Composer: %s, Key: %s%n", name, piece, key);
                }
        );
    }
}


