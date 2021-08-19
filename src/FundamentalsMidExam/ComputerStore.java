import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalWithoutTax = 0;
        while (!input.equals("regular") && !input.equals("special")) {
            double currentPrince = Double.parseDouble(input);
            if (currentPrince < 0) {
                System.out.println("Invalid price!");
            } else {
                totalWithoutTax += currentPrince;
            }
            input = scanner.nextLine();
        }
        if (totalWithoutTax == 0) {
            System.out.println("Invalid order!");
            return;
        }
        double taxes = totalWithoutTax * 0.2;
        double finalPrice = totalWithoutTax + taxes;
        if (input.equals("special")) {
            finalPrice = finalPrice * 0.9;
        }
        printReceip(taxes, finalPrice, totalWithoutTax);
    }

    private static void printReceip(double taxes, double finalPrice, double totalWithoutTax) {
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", totalWithoutTax);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$", finalPrice);
    }
}
