import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double number = Double.parseDouble(scanner.nextLine());
            long power = Long.parseLong(scanner.nextLine());
            BigDecimal result = new BigDecimal(String.valueOf(Math.pow(number, power)));
            System.out.printf(new DecimalFormat("0.#######").format(result));
        }
    }

