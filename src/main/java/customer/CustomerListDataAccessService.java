package customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerListDataAccessService implements CustomerDAO {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public int addCustomerToDatabase(Customer customer){
        customers.add(customer);
        return 1;
    };

    public int deleteCustomerFromDatabase(Customer customer){
        customers.remove(customer);
        return 1;
    };


    public List<Customer> getCustomers(){
        return customers;
    };
}
