import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        orders(product, quantity);
    }

    private static void orders(String product, int quantity) {
        double sum = 0;
        switch (product) {
            case "coffee":
                sum = quantity * 1.50;
                break;
            case "water":
                sum = quantity * 1.00;
                break;
            case "coke":
                sum = quantity * 1.40;
                break;
            case "snacks":
                sum = quantity * 2.00;
                break;
        }
        System.out.printf("%.2f",sum);
    }
}
