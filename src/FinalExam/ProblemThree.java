import java.util.*;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> dictionary = new TreeMap<>();
        String[] input = scanner.nextLine().split(" \\| ");
        for (String definition : input) {
            String[] definitions = definition.split(": ");
            dictionary.putIfAbsent(definitions[0], new ArrayList<>());
            for (int i = 1; i < definitions.length; i++) {
                dictionary.get(definitions[0]).add(definitions[i]);
            }
        }
        String[] output = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();
        if ("Hand Over".equals(command)) {
            dictionary.forEach((key, value) -> System.out.print(String.format("%s ", key)));
        } else if (command.equals("Test")) {
            for (String wordDef : output) {
                if (dictionary.containsKey(wordDef)) {
                    System.out.println(String.format("%s:", wordDef));
                    dictionary.get(wordDef).stream().sorted((word1, word2) -> Integer.compare(word2.length(), word1.length()))
                            .forEach(word -> System.out.println(String.format(" -%s", word)));
                }
            }
        }
    }
}