import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> carMileage = new TreeMap<>();
        Map<String, Integer> carFuel = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] tokes = input.split("\\|");
            String carName = tokes[0];
            int kilometers = Integer.parseInt(tokes[1]);
            int fuel = Integer.parseInt(tokes[2]);
            carMileage.put(carName, kilometers);
            carFuel.put(carName, fuel);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandArray = command.split(" : ");
            String commandName = commandArray[0];
            String carName = commandArray[1];
            switch (commandName) {
                case "Drive":
                    int distance = Integer.parseInt(commandArray[2]);
                    int fuel = Integer.parseInt(commandArray[3]);
                    if (fuel >= carFuel.get(carName)) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int currentKm = carMileage.get(carName) + distance;
                        int currentFuel = carFuel.get(carName) - fuel;
                        carMileage.put(carName, currentKm);
                        carFuel.put(carName, currentFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuel);
                        if (carMileage.get(carName) >= 100000) {
                            System.out.printf("Time to sell the %s!%n", carName);
                            carMileage.remove(carName);
                            carFuel.remove(carName);
                        }
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(commandArray[2]);
                    int currentFuel = carFuel.get(carName);
                    int refueledTank = currentFuel + refuel;
                    if (refueledTank > 75) {
                        refueledTank = 75;
                    }
                    carFuel.put(carName, refueledTank);
                    System.out.printf("%s refueled with %d liters%n", carName, refueledTank - currentFuel);
                    break;
                case "Revert":
                    int kmToDecrease = Integer.parseInt(commandArray[2]);
                    int currentKm = carMileage.get(carName);
                    int decreasedKm = currentKm - kmToDecrease;
                    if (decreasedKm < 10000) {
                        decreasedKm = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, kmToDecrease);
                    }
                    carMileage.put(carName, decreasedKm);
                    break;
            }
            command = scanner.nextLine();
        }
        carMileage.entrySet().stream().sorted((car1, car2) -> Integer.compare(car2.getValue(), car1.getValue()))
                .forEach(car -> {
                    String name = car.getKey();
                    int km = car.getValue();
                    int fuel = carFuel.get(name);
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", name, km, fuel);
                });
    }
}
