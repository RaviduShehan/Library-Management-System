package Library;

public class Items {
    private String isbn;
    private String title;
    private String section;

    public Items() {
    }

    public Items(String isbn, String title, String section) {
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setSection(section);
    }

    public static void add(Items blist) {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
