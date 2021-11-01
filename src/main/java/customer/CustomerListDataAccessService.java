package customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CustomerListDataAccessService implements CustomerDAO, Serializable {
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomerListDataAccessService{" +
                "customers=" + customers +
                '}';
    }

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
    public int readIntoListFromFile() {
        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream("src/customers.txt")) {
            objectInputStream = new ObjectInputStream(fileInputStream);
            List<Customer> customerDatabase = (List<Customer>) objectInputStream.readObject();
            objectInputStream.close();
            this.setCustomers(customerDatabase);
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


