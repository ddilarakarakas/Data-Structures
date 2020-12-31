import java.util.ArrayList;
import java.util.List;
/**
 * This class has customers and cargos.It is headquarters.
 */
public abstract class CargoCompany{
    protected int cargoNumbers;
    protected int customerNumbers;
    protected List<Customer> customers;
    public CargoCompany(){
        setCargoNumbers(0);
        setCustomerNumbers(0);
        customers = new ArrayList<>();
    }
    public CargoCompany(Customer customer){
        int cargoNumbers_ = customer.getCargoNumbers();
        int customerNumbers_ = 1;
        setCargoNumbers(cargoNumbers_);
        setCustomerNumbers(customerNumbers_);
        customers = new ArrayList<>();
        setCustomers(customer);
    }
    public void setCustomers(Customer newCustomer){
        customers.add(newCustomer);
        customerNumbers++;
    }
    public Customer getCustomers(int num){
        return customers.get(num);
    }
    public void setCargoNumbers(int numbers){
        cargoNumbers = numbers;
    }
    public int getCargoNumbers(){
        return cargoNumbers;
    }
    public void setCustomerNumbers(int num){
        customerNumbers = num;
    }
    public int getCustomerNumbers(){
        return customerNumbers;
    }
    public abstract void printForTest();
    public String toString(){
        return String.format("%s\n","Cargo Company");
    }
}
