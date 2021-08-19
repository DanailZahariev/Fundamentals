public class Articles {
    private String title;
    private String content;
    private String author;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Articles(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String newContent) {
        this.content = newContent;
    }

    public void change(String newAuthor) {
        this.author = newAuthor;
    }

    public void rename(String newTittle) {
        this.title = newTittle;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", title, content, author);
    }
}
