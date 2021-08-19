import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, plantInformation> plants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String plantInfo = scanner.nextLine();
            String[] plantParts = plantInfo.split("<->");
            String plantName = plantParts[0];
            int plantRarity = Integer.parseInt(plantParts[1]);
            plantInformation newPlant = new plantInformation(new ArrayList<>(), plantRarity);
            plants.put(plantName, newPlant);
        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandArray = command.split(": | - ");
            String commandName = commandArray[0];
            String plantName = commandArray[1];
            if (!plants.containsKey(plantName)) {
                command = scanner.nextLine();
                System.out.println("error");
                continue;
            }
            switch (commandName) {
                case "Rate":
                    int rating = Integer.parseInt(commandArray[2]);
                    plants.get(plantName).addRating(rating);
                    break;
                case "Update":
                    int rarity = Integer.parseInt(commandArray[2]);
                    plants.get(plantName).setRarity(rarity);
                    break;
                case "Reset":
                    plants.get(plantName).removeRatings();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().stream().sorted((plant1, plant2) -> {
            int result = Integer.compare(plant2.getValue().getRarity(), plant1.getValue().getRarity());
            if (result == 0) {
                result = Double.compare(plant2.getValue().averageRating(),plant1.getValue().averageRating());
            }
            return result;
        }).forEach(p-> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",p.getKey(),p.getValue().getRarity(),p.getValue().averageRating())
             );
    }
}

class plantInformation {
    private List<Integer> ratings;
    private int rarity;

    public void removeRatings() {
        this.ratings.clear();
    }

    public void addRating(int rating) {
        this.ratings.add(rating);
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getRarity() {
        return rarity;
    }

    public double averageRating() {
        double sum = 0;
        for (Integer rating : this.ratings) {
            sum += rating;
        }
        if (sum == 0) {
            return 0;
        } else {
            return sum / this.ratings.size();
        }
    }

    public plantInformation(List<Integer> ratings, int rarity) {
        this.rarity = rarity;
        this.ratings = ratings;
    }
}