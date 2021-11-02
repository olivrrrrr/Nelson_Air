package customer;

public interface CustomerDAO {

    //Interface to allow customers to be added, deleted and searched for in a database
    int addCustomerToDatabase(Customer customer, CustomerDatabase customerDatabase);
    int deleteCustomerFromDatabase(Customer customer, CustomerDatabase customerDatabase);
    Customer searchForCustomerFromDataBase(String passportnumber, CustomerDatabase customerDatabase);
}
