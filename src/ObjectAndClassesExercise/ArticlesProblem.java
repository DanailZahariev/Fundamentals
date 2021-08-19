import java.util.Scanner;

public class ArticlesProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String articleData = scanner.nextLine();
        String[] splitData = articleData.split(", ");
        String article = splitData[0];
        String content = splitData[1];
        String author = splitData[2];
        Articles articles = new Articles(article, content, author);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            String commandName = command.split(": ")[0];
            String commandElement = command.split(": ")[1];
            switch (commandName) {
                case "Edit":
                    articles.edit(commandElement);
                    break;
                case "ChangeAuthor":
                    articles.change(commandElement);
                    break;
                case "Rename":
                    articles.rename(commandElement);
                    break;

            }

        }
        System.out.println(articles.toString());
    }
}
