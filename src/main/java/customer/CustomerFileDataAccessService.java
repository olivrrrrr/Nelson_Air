package customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerFileDataAccessService implements CustomerDAO {

    @Override
    public int addCustomerToDatabase(Customer customer) {
        try {
            //new file object with desired pathname
            File file = new File("src/customers.txt");

            //append customer to end of file
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

    public int deleteCustomerFromDatabase(Customer customerToDelete){
        //Instantiate old file with pathname of current customer file
        File oldFile = new File("src/customers.txt");

        //Instantiate new file with temporary target pathname
        File file = new File("src/customers1.txt");

        //Instantiate new arraylist of customers to store customer objects
        List<String> customers = new ArrayList<>();

        //try and catch in the case of an IO exception
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(file);
            Scanner scanner = new Scanner(oldFile);

//            if(scanner.hasNextLine()){
            //Whilst the oldfile still has lines to scan
                while(scanner.hasNext()) {
                    //scan the next line
                    String nextLine = scanner.nextLine();

                    //add next line to customers if line isn't empty or contains the passport
                    //number of the customer to remove
                    if (!nextLine.isEmpty() &&
                            !nextLine.contains(customerToDelete.getPassportNumber()))
                    {
                        customers.add(nextLine);
                    }
                }
                //Print every line of customers to new text file
                for (String customer : customers)
                {
                    printWriter.println(customer);
                }
                printWriter.flush();
                printWriter.close();

                //Delete old file
                oldFile.delete();

                //rename new file to oldfile pathname so that method works on multiple runnings of CLI
                file.renameTo(new File("src/customers.txt"));
//            }
        } catch(IOException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
