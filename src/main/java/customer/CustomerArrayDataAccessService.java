package customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CustomerArrayDataAccessService implements CustomerDAO, Serializable {

    @Override
    public int addCustomerToDatabase(Customer customer, CustomerDatabase customerDatabase) {
        Customer[] customerArray = customerDatabase.getCustomerArray();
        if(Arrays.stream(customerDatabase.getCustomerArray()).anyMatch(person -> person.equals(customer))) {
            System.out.println("Customer already in database");
            return 0;
        }
        else {
            boolean isFull = true;
            int listLength = customerArray.length;
            for (int i = 0; i < listLength; i++) {
                if (customerArray[i] == null) {
                    customerArray[i] = customer;
                    isFull = false;
                    break;
                }
            }
            if (isFull == true) {
                return 0;
            }
            return 1;
        }
    }

    @Override
    public int deleteCustomerFromDatabase(Customer customer, CustomerDatabase customerDatabase) {
        Customer[] customerArray = customerDatabase.getCustomerArray();
        int customerListLength = customerArray.length;

        for(Customer customerAtIndex : customerArray ){
            if(customerAtIndex.equals(customer)){
                customerAtIndex = null;
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Customer searchForCustomerFromDataBase(String passportnumber, CustomerDatabase customerDatabase) {
        // Get the customer database
        Customer[] customerDatabaseArray = customerDatabase.getCustomerArray();
        // Loop thru the customer database
        int customerDatabaseListLength = customerDatabaseArray.length;
        for(int i=0; i < customerDatabaseListLength; i++){
            if(customerDatabaseArray[i] != null && passportnumber.equals(customerDatabaseArray[i].getPassportNumber())){
                return customerDatabaseArray[i];
            }
        }
        Customer newCustomer = new Customer(null, null, null, null);
        return  newCustomer;
    }
}
