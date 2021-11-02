package customer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CustomerDatabase {
    private Customer[] customerArray;
    private List <Customer> customerList;

    public CustomerDatabase() {
        this.customerArray = new Customer[50];
        this.customerList = new ArrayList<Customer>();
    }

    public Customer[] getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(Customer[] customerArray) {
        this.customerArray = customerArray;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDatabase that = (CustomerDatabase) o;
        return Arrays.equals(customerArray, that.customerArray) && Objects.equals(customerList, that.customerList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customerList);
        result = 31 * result + Arrays.hashCode(customerArray);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerDatabase{" +
                "customerArray=" + Arrays.toString(customerArray) +
                ", customerList=" + customerList +
                '}';
    }
}
