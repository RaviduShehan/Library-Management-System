package Library;

public abstract class LibraryItem {
    private String title;
    private String section;
    public int dateSBorrowed;
    private String currentUser;

    public LibraryItem(String title,String section, int dateBorrowed, String currentUser) {
        this.title= title;
        this.section= section;
        this.dateSBorrowed = dateBorrowed;
        this.currentUser=currentUser;

    }

    public LibraryItem() {

    }


    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public int getDateSBorrowed() {
        return dateSBorrowed;
    }

    public String getCurrentUser() {
        return currentUser;
    }
    public void display(){
        System.out.println("Tittle : "+this.title);
        System.out.println("Section : " +this.section);
        System.out.println("Borrwed date : " +this.dateSBorrowed);
    }

}
