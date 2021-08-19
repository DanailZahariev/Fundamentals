import java.util.Scanner;

public class GreaterTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        switch (type) {
            case "int":
                int firstInt = Integer.parseInt(scanner.nextLine());
                int secondInt = Integer.parseInt(scanner.nextLine());
                int resultInt = getMax(firstInt, secondInt);
                System.out.println(resultInt);
                break;
            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                char resultChar = getMaxChar(firstChar, secondChar);
                System.out.println(secondChar);
                break;
            case "string":
                String firstString = scanner.nextLine();
                String secondString = scanner.nextLine();
                String resultString = getMaxString(firstString, secondString);
                System.out.println(resultString);
                break;
        }
    }

    private static String getMaxString(String firstString, String secondString) {
        int first = firstString.compareTo(secondString);
        if (first >= 0) {
            return firstString;
        }
        return secondString;
    }

    private static char getMaxChar(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        }
        return secondChar;
    }

    private static int getMax(int firstInt, int secondInt) {
        if (firstInt > secondInt) {
            return firstInt;
        }
        return secondInt;
    }
}
