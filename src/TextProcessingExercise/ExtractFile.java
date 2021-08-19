import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        String[] fileParts = filePath.split("\\\\");
        String fullFileName = fileParts[fileParts.length - 1];
        String fileName = fullFileName.split("\\.")[0];
        String extension = fullFileName.split("\\.")[1];
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " +extension);
    }
}
