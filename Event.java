import java.util.Scanner;

public class Event {
    public static void main(String[] args) {
        Scanner inpt = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String eventName = inpt.nextLine();
        System.out.print("Enter event date: ");
        String eventDate = inpt.nextLine();
        System.out.print("Enter event location: ");
        String eventLocation = inpt.nextLine();

        System.out.println("\nEntered event is ");
        System.out.println("--------------------");
        System.out.println("Name     : " + eventName);
        System.out.println("Date     : " + eventDate);
        System.out.println("Loaction : " + eventLocation);
    }
}
