import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        getRectangleArea(width,height);
    }

    private static void getRectangleArea(double width, double height) {
        double area = width * height;
        System.out.printf("%.0f",area);
    }
}
