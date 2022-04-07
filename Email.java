package emailApp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 4;
    private int defaultPasswordLenght = 10;
    private String alternateEmail;
    private String companySuffix = "demirelholding.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
       // System.out.println("NEW EMAIL CREATED:" + this.firstName + " " + this.lastName);

        //call a method and asking for the department  - return the department
         this.department =setDepartment();
       // System.out.println("Department: " + this.department);

        //call a method and this method returns a random password
        this.password = randomPassword(defaultPasswordLenght);
        System.out.println("Your password is: " + this.password);

        //combine elemenets to generate email
        email =firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@"+ department + "." + companySuffix;
        System.out.println("Your email is :" +email);
    }
    // Ask for the department

    private String setDepartment() {
        System.out.println("enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acc";
        } else {
            return "";
        }



    }
    //Generate a random password
   private String randomPassword(int lenght){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXWYZ123456789+-";
        char [] password = new char[lenght];
        for(int i =0; i<lenght;i++){
           int rand= (int) (Math.random() * passwordSet.length()); //Math.random() komutu ile passswordSet içerisinde beirtilen
            //içeriğin uzunluğunu rastgele olarark seçecektir.
           password[i] = passwordSet.charAt(rand);
//charAt komutu ile bir string dizisi içerisinde belirtilen sıradaki karakreri alır.

        }
        return new String(password);
   }
    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailBoxCapacity =capacity;

    }
    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return  alternateEmail;}
    public String getPassword(){return  password;}

    public String showInfo(){
        return  "display name: " + firstName+ " " + lastName+ " "+
                "\ncompany email: " + email + " "+
                "\nmailbox capacity: " + mailBoxCapacity + "gb";

    }



}
