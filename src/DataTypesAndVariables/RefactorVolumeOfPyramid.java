import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length, width, heigth = 0;
        System.out.print("Length: ");
        length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        heigth = Double.parseDouble(scanner.nextLine());
        heigth = (length * width * heigth) / 3;
        System.out.printf("Pyramid Volume: %.2f", heigth);
    }
}
