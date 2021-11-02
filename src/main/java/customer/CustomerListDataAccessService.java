package customer;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerListDataAccessService implements CustomerDAO, Serializable {

    @Override
    public int addCustomerToDatabase(Customer customer, CustomerDatabase customerDatabase){
        //Search for a match within the list database
        Boolean customerExists = customerDatabase.getCustomerList().stream()
                .anyMatch(repeat -> repeat.equals(customer));
        //If true return 0 and error message, else return 0 with success message
        if (customerExists) {
            System.out.println("Passport number already in the system");
            return 0;
        }
        else {
            customerDatabase.getCustomerList().add(customer);
            System.out.println("Customer added to database");
            return 1;
        }
    };

    @Override
    public int deleteCustomerFromDatabase(Customer customer, CustomerDatabase customerDatabase) {
        customerDatabase.getCustomerList().remove(customer);
        return 0;
    }

    @Override
    public Customer searchForCustomerFromDataBase(String passportNumber, CustomerDatabase customerDatabase) {
            //Use streams to find customer from given passportnumber
            List<Customer> result =  customerDatabase.getCustomerList().stream().filter(person -> person
                    .getPassportNumber().equals(passportNumber)).collect(Collectors.toList());
            try {
                //If found return customer (e.g. first and only entry of the list returned
                return result.stream().findAny().get();
            } catch (NoSuchElementException e) {
                //Else throw an error
                System.out.println("No such customer exists in our database.");
                return null;
            }
    }

    public int readIntoListFromFile(CustomerDatabase customerDatabase) {
        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream("src/customers.txt")) {
            objectInputStream = new ObjectInputStream(fileInputStream);
            List<Customer> newDatabase = (List<Customer>) objectInputStream.readObject();
            objectInputStream.close();
            customerDatabase.setCustomerList(newDatabase);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

}


