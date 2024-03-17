import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;
public class Theatre{
//create arrays
    static int[] row1=new int[12];
    static int[] row2=new int[16];
    static int[] row3=new int[20];
    static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the New Theatre");
for(int i=0;i< row1.length;i++){
    row1[i]=0;
}
//initially make the seat nos available
        for (int i = 0; i < row1.length; i++) {
            row1[i] = 0;
        }

        for (int i = 0; i < row2.length; i++) {
            row2[i] = 0;
        }

        for (int i = 0;  i < row3.length; i++) {
            row3[i] = 0;
        }
        while (true) {
            System.out.println("Please select an option:\n1) Buy a ticket \n" +
                    "2) Print seating area \n" +
                    "3) Cancel ticket \n" +
                    "4) List available seats \n" +
                    "5) Save to file \n" +
                    "6) Load from file \n" +
                    "7) Print ticket information and total price \n" +
                    "8) Sort tickets by price \n" +
                    "0) Quit \n" +
                    "-------------------------------------------------\n" +
                    "Enter option:");

            try {
                //getting the user input to navigate the user correctly
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        load();
                        break;
                    case 7:
                        show_tickets_info();
                        break;
                    case 8:
                        sort_tickets();
                        break;
                    case 0:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Please Enter an integer");
                sc.nextLine();
            }
        }
    }

    public static void buy_ticket(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input Person's name : ");
        String name=sc.nextLine();

        System.out.println("Input Person's surname : ");
        String surname=sc.nextLine();

        System.out.println("Input Person's email : ");
        String email=sc.nextLine();

        System.out.println("Input a raw number : ");
        int row=sc.nextInt();


        // Check if row and seat numbers are valid
        if (row < 1 || row > 3) {
            System.out.println("Error! This row number does not exist. Please select 1-3.");
          //if the row number is invalid, directing his to the main function
            return;
        }

        System.out.println("Input a seat number : ");
        int seat=sc.nextInt()-1;

        if(row==1){
            if(seat>row1.length){
                //check the seat is valid or invalid
                System.out.println("Invalid seat number.");
                return;
            }
            else{
                if(row1[seat]==0)
                {
                    row1[seat]=1;
                }
                else if(row1[seat]==1)
                {
                    //if the seat is unavailable, shows it unavailable
                    System.out.println("The seat has been already booked. Please try again");
                    return;
                }
            }
        }
        else if(row==2){
            if(seat>row2.length){
                //check the seat is valid or invalid
                System.out.println("Invalid seat number.");
                return;
            }
            else{
                if(row2[seat]==0)
                {
                    row2[seat]=1;
                }
                else if(row2[seat]==1)
                {
                    //if the seat is unavailable, shows it unavailable
                    System.out.println("The seat has been already booked. Please try again");
                    return;
                }
            }
        }
        else if(row==3){
            if(seat>row3.length){
                //check the seat is valid or invalid
                System.out.println("Invalid seat number.");
                return;
            }
            else{
                if(row3[seat]==0)
                {
                    row3[seat]=1;
                }
                else if(row3[seat]==1)
                {
                    //if the seat is unavailable, shows it unavailable
                    System.out.println("The seat has been already booked. Please try again");
                    return;
                }
            }
        }

        System.out.println("Please enter the price");
        double price=sc.nextDouble();

        Person person=new Person(name,surname,email);
        Ticket ticket =new Ticket(row,seat,price,person);
        //add the ticket to the tickets array
        tickets.add(ticket);
    }
    public static void print_seating_area(){
        System.out.println("    ***********");
        System.out.println("    *  STAGE  *");
        System.out.println("    ***********");
        System.out.print("    ");
        for (int i = 0; i < row1.length; i++) {
            if(i== row1.length/2) {
                System.out.print(" ");
            }
            if(row1[i]==0){
                System.out.print("0");
            }
            else{
                System.out.print("X");
            }
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < row2.length; i++) {
            if(i== row2.length/2) {
                System.out.print(" ");
            }
            if(row2[i]==0){
                System.out.print("0");
            }
            else{
                System.out.print("X");
            }
        }
        System.out.println();
        for (int i = 0; i < row3.length; i++) {
            if(i== row3.length/2)
            {
                System.out.print(" ");
            }
            if(row3[i]==0){
                System.out.print("0");
            }
            else{
                System.out.print("X");
            }
        }
        System.out.println();
    }

    public static void cancel_ticket(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input a raw number : ");
        int row=sc.nextInt();
        System.out.println("Input a seat number : ");
        int seat=sc.nextInt()-1;

        // Check if row and seat numbers are valid
        if (row < 1 || row > 3) {
            System.out.println("Invalid row number.");
            return;
        }
        if(row==1){
            if(seat>row1.length){
                System.out.println("Invalid seat number.");
            }
            else{
                if(row1[seat]==1)
                {
                    row1[seat]=0;
                }
            }
        }
        else if(row==2){
            if(seat>row2.length){
                System.out.println("Invalid seat number.");
            }
            else{
                if(row2[seat]==1)
                {
                    row2[seat]=0;
                }
            }
        }
        else if(row==3){
            if(seat>row3.length){
                System.out.println("Invalid seat number.");
            }
            else{
                if(row3[seat]==1)
                {
                    row3[seat]=0;
                }
            }
        }
    }

    public static void show_available(){
        System.out.print("Seats available in row 1: ");
        for(int i=0;i<row1.length;i++){
            if(row1[i]==0){
                System.out.print((i+1)+", ");
            }
        }
        System.out.println();

        System.out.print("Seats available in row 2: ");
        for(int i=0;i<row2.length;i++){
            if(row2[i]==0){
                System.out.print((i+1)+", ");
            }
        }
        System.out.println();

        System.out.print("Seats available in row 3: ");
        for(int i=0;i<row3.length;i++){
            if(row3[i]==0){
                System.out.print((i+1)+", ");
            }
        }
        System.out.println();
    }

    public static void save() {
        try {
            File file = new File("filename.txt");
            FileWriter writer = new FileWriter(file);

            // Write the data to the file
            writer.write("Seats available in row 1: ");
            for (int i = 1; i <= row1.length; i++) {
                if (row1[i-1]==0) {
                    writer.write((i) + " ");
                } else {
                    writer.write("_ ");
                }

            }
            writer.write("\n");
            writer.write("Seats available in row 2: ");
            for (int i = 1; i <= row2.length; i++) {
                if (row2[i-1]==0) {
                    writer.write((i)+ " ");
                } else {
                    writer.write("_ ");
                }

            }
            writer.write("\n");
            writer.write("Seats available in row 3: ");
            for (int i = 1; i <= row3.length; i++) {
                if (row3[i-1]==0) {
                    writer.write((i) + " ");
                } else {
                    writer.write("_ ");
                }
            }
            writer.write("\n");

            writer.close();
            System.out.println("File saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void load() {
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static  void show_tickets_info(){
        if (tickets.isEmpty()) {
            System.out.println("No tickets bought yet.");
            return;
        }

        double total = 0;

        for (Ticket ticket : tickets) {
            System.out.println("Row " + ticket.getRow() + ", Seat " + ticket.getSeat() +
                    ", Price £" + ticket.getPrice() + ", Name " + ticket.getPerson().getName() +
                    ", Surname " + ticket.getPerson().getSurname() + ", Email " + ticket.getPerson().getEmail());
            total += ticket.getPrice();
        }

        System.out.println("Total price of all tickets: £" + total);
    }

    public static void sort_tickets() {
        Collections.sort(tickets, Comparator.comparingDouble(Ticket::getPrice)); // sort by price in ascending order
        System.out.println("Sorted tickets by price:");
        for (Ticket ticket : tickets) {
            System.out.println("Row " + ticket.getRow() + ", Seat " + ticket.getSeat() +
                    ", Price £" + ticket.getPrice() + ", Name " + ticket.getPerson().getName() +
                    ", Surname " + ticket.getPerson().getSurname() + ", Email " + ticket.getPerson().getEmail());
        }

    }

}
