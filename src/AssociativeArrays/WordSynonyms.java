import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countWords = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonymDic = new LinkedHashMap<>();
        for (int i = 0; i < countWords; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            if (!synonymDic.containsKey(word)) {
                List<String> synonymCurrent = new ArrayList<>();
                synonymCurrent.add(synonym);
                synonymDic.put(word, synonymCurrent);
            } else {
                List<String> synonymCurrent = synonymDic.get(word);
                synonymCurrent.add(synonym);
                synonymDic.put(word, synonymCurrent);
            }
        }
        for (Map.Entry<String, List<String>> word : synonymDic.entrySet()) {
            String currentWord = word.getKey();
            List<String> synonymForCurrentWord = word.getValue();
            System.out.printf("%s - %s%n", currentWord, String.join(", ", synonymForCurrentWord));
        }
    }
}
