package Library;

public class Book extends LibraryItem{
    private int isbn;
    private String authors;
    private int numberofPages;
    private int publishiedDate;


    public Book() {
        super();
//        super(title, section, dateSBorrowed, currentUser);
        this.isbn=isbn;
        this.authors=authors;
        this.numberofPages=numberofPages;

    }

    public int getIsbn() {
        return isbn;
    }

    public String getAuthors() {
        return authors;
    }

    public int getNumberofPages() {
        return numberofPages;
    }

    public int getPublishiedDate() {
        return publishiedDate;
    }
    @Override
    public  void display(){
        System.out.println("Books Available");
        super.display();
        System.out.println("ISBN number : "+this.isbn);
        System.out.println("Author of the Book : " +this.authors);
        System.out.println("Number of pages : "+this.numberofPages);
        System.out.println("Published Date : "+this.publishiedDate);
    }


}
