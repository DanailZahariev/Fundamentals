import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstRow = scanner.nextLine();
        String secondRow = scanner.nextLine();
        String[] firstArray = firstRow.split(" ");
        String[] secondArray = secondRow.split(" ");
        for (String word : secondArray) {
            for (String secondWord : firstArray) {
                if (secondWord.equals(word)) {
                    System.out.print(word + " ");
                }
            }
        }
    }
}
