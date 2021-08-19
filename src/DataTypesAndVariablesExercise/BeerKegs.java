import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countKeg = Integer.parseInt(scanner.nextLine());
        double maxVolume = Double.MIN_VALUE;
        String biggerKeg = "";
        for (int keg = 1; keg <= countKeg; keg++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > maxVolume) {
                maxVolume = volume;
                biggerKeg = model;
            }
        }
        System.out.println(biggerKeg);
    }
}
