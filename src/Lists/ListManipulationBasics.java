import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        List <Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }
        String command = scanner.nextLine();
        while (!"end".equals(command)){
            String [] tokens = command.split(" ");
            switch (tokens[0]){
                case "Add":
                    int numberToAdd = Integer.parseInt(tokens[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(tokens[1]);
                    numbers.remove((Object)numberToRemove);
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    numbers.remove(indexToRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(tokens[1]);
                    int atGivenIndex = Integer.parseInt(tokens[2]);
                    numbers.add(atGivenIndex, numberToInsert);
                    break;
            }command= scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}


