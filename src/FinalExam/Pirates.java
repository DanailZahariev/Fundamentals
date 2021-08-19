import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Integer>> cities = new LinkedHashMap<>();
        while (!input.equals("Sail")) {
            String[] cityData = input.split("\\|\\|");
            String cityName = cityData[0];
            int population = Integer.parseInt(cityData[1]);
            int gold = Integer.parseInt(cityData[2]);
            if (cities.containsKey(cityName)) {
                List<Integer> currentCity = cities.get(cityName);
                int currentPopulation = currentCity.get(0);
                int currentGold = currentCity.get(1);
                currentCity.set(0, currentPopulation + population);
                currentCity.set(1, currentGold + gold);
                cities.put(cityName, currentCity);
            } else {
                cities.put(cityName, Arrays.asList(population, gold));
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandArray = input.split("=>");
            String commandName = commandArray[0];
            String cityName = commandArray[1];
            switch (commandName) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(commandArray[2]);
                    int goldPlundered = Integer.parseInt(commandArray[3]);
                    int pplBeforePlunder = cities.get(cityName).get(0);
                    int goldBeforePlunder = cities.get(cityName).get(1);
                    int remainingPpl = pplBeforePlunder - peopleKilled;
                    int remainingGold = goldBeforePlunder - goldPlundered;
                    if (remainingGold <= 0 || remainingPpl <= 0) {
                        if (remainingGold <= 0) {
                            goldPlundered = goldBeforePlunder;
                        }
                        if (remainingPpl <= 0) {
                            peopleKilled = pplBeforePlunder;
                        }
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, goldPlundered, peopleKilled);
                        System.out.printf("%s has been wiped off the map!%n", cityName);
                        cities.remove(cityName);
                        break;
                    }
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", cityName, goldPlundered, peopleKilled);
                    cities.put(cityName, Arrays.asList(remainingPpl, remainingGold));
                    break;
                case "Prosper":
                    int goldProsper = Integer.parseInt(commandArray[2]);
                    if (goldProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }
                    int goldBeforeProsper = cities.get(cityName).get(1);
                    int goldAfterProsper = goldBeforeProsper + goldProsper;
                    cities.get(cityName).set(1, goldAfterProsper);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, cityName, goldAfterProsper);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
        cities.entrySet().stream().sorted((left, right) -> {
            int result = right.getValue().get(1).compareTo(left.getValue().get(1));
            if (result == 0) {
                result = left.getKey().compareTo(right.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s -> Population: %s citizens, Gold: %d kg%n"
                , entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
    }
}
