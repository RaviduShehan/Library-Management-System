package Library;

import java.util.Scanner;

public class Reader {
    private int id;
    private String name;
    private String mobileNo;
    private String email;

    public Reader(int id, String name, String mobileNo, String email){
        this.id=id;
        this.name=name;
        this.mobileNo=mobileNo;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void displayReder(){
        System.out.println("Id :" +this.id);
        System.out.println("Name : " +this.name);
        System.out.println("Mobile number : "+this.mobileNo);
        System.out.println("Email : " +this.email);
    }
    public int getItems(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the isbn number to select an item");
        int item=sc.nextInt();
        return item;
    }

}
