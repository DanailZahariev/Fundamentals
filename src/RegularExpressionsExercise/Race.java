import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> racers = Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toList());
        Map<String, Integer> raceDistance = new LinkedHashMap<>();
        racers.forEach(racer -> raceDistance.put(racer, 0));
        String regexLetters = "[A-Za-z]+";
        Pattern patternName = Pattern.compile(regexLetters);
        String regexDistance = "[0-9]";
        Pattern patternDistance = Pattern.compile(regexDistance);
        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            StringBuilder name = new StringBuilder();
            Matcher matcherName = patternName.matcher(input);
            while (matcherName.find()) {
                name.append(matcherName.group());
            }
            int distance = 0;
            Matcher matcherDistance = patternDistance.matcher(input);
            while (matcherDistance.find()) {
                distance += Integer.parseInt(matcherDistance.group());
            }
            String racerName = name.toString();
            if (raceDistance.containsKey(racerName)) {
                int currentDistance = raceDistance.get(racerName);
                raceDistance.put(racerName, distance + currentDistance);
            }
            input = scanner.nextLine();
        }

        List<String> topThree = raceDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println("1st place: " + topThree.get(0));
        System.out.println("2nd place: " + topThree.get(1));
        System.out.println("3rd place: " + topThree.get(2));
    }
}
