package Library;

public class DateTime {
    private LibraryItem libraryItem;
    private int day;
    private int month;
    private int year;
    private int time;

    public DateTime(LibraryItem libraryItem,int day,int month,int year,int time){
        this.setLibraryItem(libraryItem);
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
        this.setTime(time);
    }

    public void setLibraryItem(LibraryItem libraryItem) {
        this.libraryItem = libraryItem;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
