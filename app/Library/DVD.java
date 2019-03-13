package Library;

public class DVD extends LibraryItem {
    private String language;
    private String subsAvailble;
    private String producer;
    private String actors;




    public DVD(String title, String section, int dateBorrowed, String currentUser, String language, String subsAvailble, String producer,String actors) {
        super(title, section, dateBorrowed, currentUser);
        this.language=language;
        this.subsAvailble=subsAvailble;
        this.producer= producer;
        this.actors=actors;
    }

    public String getLanguage() {
        return language;
    }

    public String getSubsAvailble() {
        return subsAvailble;
    }

    public String getProducer() {
        return producer;
    }

    public String getActors() {
        return actors;
    }
    @Override

    public void display(){
        System.out.println("DVDs Available");
        super.display();
        System.out.println("Language available : "+this.language);
        System.out.println("Substitles : " +this.subsAvailble);
        System.out.println("Producers : "+this.producer);
        System.out.println("Actors : "+this.actors);
    }
}
