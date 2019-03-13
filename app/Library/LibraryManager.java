package Library;

public interface LibraryManager {

    public void addBooks(Book Book);

    public void addDVD(DVD DVD);

    public void borrowBooks(Reader Reader);

    public void deleteBooks(LibraryItem LibraryItem);

    public void reportBooks(LibraryItem LibraryItem);
}