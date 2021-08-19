import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleInQueue = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] cabins = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < cabins.length; i++) {
            int peopleInCabin = cabins[i];
            int freeSpace = 4 - peopleInCabin;

            if (peopleInCabin == 4) {
                continue;
            }
            if (freeSpace >= peopleInQueue) {
                cabins[i] = cabins[i] + peopleInQueue;
                peopleInQueue = 0;
                break;
            }
            cabins[i] = 4;
            peopleInQueue = peopleInQueue - freeSpace;
        }
        boolean hasEmpty = false;
        for (int peopleInCabin : cabins) {
            if (peopleInCabin < 4) {
                hasEmpty = true;
                break;
            }
        }
        if (hasEmpty) {
            System.out.println("The lift has empty spots!");
        } else if (!hasEmpty && peopleInQueue != 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleInQueue);
        }
        Arrays.stream(cabins).forEach(value -> System.out.print(value + " "));
    }
}
