package customer;

public class CustomerDatabase {
    private Customer[] customerList;

    public CustomerDatabase(Customer[] customerList) {
        this.customerList = new Customer[10000];
    }

    public Customer[] getCustomerList() {
        return customerList;
    }

    public void setCustomerList(Customer[] customerList) {
        this.customerList = customerList;
    }
}
