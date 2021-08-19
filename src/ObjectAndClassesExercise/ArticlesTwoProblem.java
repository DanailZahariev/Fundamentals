import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArticlesTwoProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<ArticlesTwo> articles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            articles.add(new ArticlesTwo(tokens[0], tokens[1], tokens[2]));
        }
        String command = scanner.nextLine();
        switch (command) {
            case "title":
                articles.sort(Comparator.comparing(ArticlesTwo::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(ArticlesTwo::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(ArticlesTwo::getAuthor));
                break;
        }
        for (ArticlesTwo article : articles) {
            System.out.println(article.toString());
        }
    }
}

