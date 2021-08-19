import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double students = Double.parseDouble(scanner.nextLine());
        String person = scanner.nextLine();
        String day = scanner.nextLine();
        double totalPrice = 0;
        switch (person) {
            case "Students":
                switch (day) {
                    case "Friday":
                        if (students >= 30) {
                            totalPrice = students * 8.45 * 0.85;
                        } else {
                            totalPrice = students * 8.45;
                        }
                        break;
                    case "Saturday":
                        if (students >= 30) {
                            totalPrice = students * 9.80 * 0.85;
                        } else {
                            totalPrice = students * 9.80;
                        }
                        break;
                    case "Sunday":
                        if (students >= 30) {
                            totalPrice = students * 10.46 * 0.85;
                        } else {
                            totalPrice = students * 10.46;
                        }
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        if (students >= 100) {
                            students = students - 10;
                            totalPrice = students * 10.90;
                        } else {
                            totalPrice = students * 10.90;
                        }
                        break;
                    case "Saturday":
                        if (students >= 100) {
                            students = students - 10;
                            totalPrice = students * 15.60;
                        } else {
                            totalPrice = students * 15.60;
                        }
                        break;
                    case "Sunday":
                        if (students >= 100) {
                            students = students - 10;
                            totalPrice = students * 16;
                        } else {
                            totalPrice = students * 16;
                        }
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        totalPrice = students * 15;
                        break;
                    case "Saturday":
                        totalPrice = students * 20;
                        break;
                    case "Sunday":
                        totalPrice = students * 22.50;
                        break;
                }
                if (students >= 10 && students <= 20) {
                    totalPrice = totalPrice * 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
