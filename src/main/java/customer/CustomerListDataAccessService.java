package customer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    //Function that when you start program, reads data from file into list for dynamic modification
//    public int readDataFromFileIntoList () {
//        File customerDatabase = new File("src/customers.txt");
//        try {
//            Scanner scanner = new Scanner(customerDatabase);
//
//            while(scanner.hasNext()) {
//                //scan the next line
//                String nextLine = scanner.nextLine();
//
//                //add next line to customers if line isn't empty or contains the passport
//                //number of the customer to remove
//                if (!nextLine.isEmpty())
//                {
//                    customers.add(nextLine);
//                }
//            }
//
//        } catch (IOException e) {
//
//        }
//    }
}


