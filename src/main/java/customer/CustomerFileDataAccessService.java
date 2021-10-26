package customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class CustomerFileDataAccessService implements CustomerDAO {

    @Override
    public int addCustomerToDatabase(Customer customer) {
        try {
            File file = new File("src/customers.txt");
//            if(!file.exists()){
//                file.createNewFile();
//            }
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(customer);

            printWriter.flush();
            printWriter.close();

            return 1;
        } catch (IOException e) {
            return 0;
        }
    }

    ;
//    public int deleteCustomerFromDatabase(Customer customer){
//           CustomerListDataAccessService customerListDataAccessService = new CustomerListDataAccessService();
//           CustomerListDataAccessService newCustomerList =
//                   customerListDataAccessService.deleteCustomerFromDatabase(customer);
//
//    };

    //    List<Customer> getCustomers();
//    public Customer[] readFromTextFile(File file) {
//        try {
//            Scanner scanner = new Scanner(file);
//            FileWriter fileWriter = new FileWriter(file);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//            printWriter.flush();
//            printWriter.close();
//
//        } catch (Exception e) {
//
//        }
//    }
}
