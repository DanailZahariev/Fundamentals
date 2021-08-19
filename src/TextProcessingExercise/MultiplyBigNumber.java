import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        BigInteger firstNum = new BigInteger(first);
        BigInteger secondNum = new BigInteger(second);
        System.out.print(firstNum.multiply(secondNum));
    }
}
