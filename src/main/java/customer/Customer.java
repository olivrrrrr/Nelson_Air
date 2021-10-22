package customer;

public class Customer {

    private String name;
    private int passportNumber;
    private Long number;
    private String email;
    private Ticket [] ticket;

    public Customer(String name, int passportNumber, Long number, String email, Ticket[] ticket) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.number = number;
        this.email = email;
        this.ticket = ticket;
    }

    public String getName() {
        return name;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public Long getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public Ticket[] getTicket() {
        return ticket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTicket(Ticket[] ticket) {
        this.ticket = ticket;
    }
}
