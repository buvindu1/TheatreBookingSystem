public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person person;
    //created getters and setters to access the private variables
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;

    }

    public static void print(Ticket t){
        System.out.println("Person name: "+t.person.getName());
        System.out.println("Person surname: "+t.person.getSurname());
        System.out.println("Person email: "+t.person.getEmail());
        System.out.println("Row: ");
        System.out.println("Seat: ");
        System.out.println("Price: ");
    }
}
