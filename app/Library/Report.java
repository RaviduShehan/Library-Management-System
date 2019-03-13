package Library;

public class Report {
    private String isbn;
    private String id;
    private String borrowDate;

public Report(String isbn, String id, String borrowDate){
    this.isbn=isbn;
    this.id=id;
    this.borrowDate=borrowDate;
}
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
}
