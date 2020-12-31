/**
 * This class has customers and cargos.It is headquarters.
 */
public class CargoCompany{
    protected int cargoNumbers;
    protected int customerNumbers;
    protected int branchNumbers;
    protected Customers[] customers;
    protected String[] branch;
    public CargoCompany(){
        setCargoNumbers(0);
        setCustomerNumbers(0);
        setBranchNumbers(0);
        customers = new Customers[50];
        branch = new String[10];
    }
    public CargoCompany(String branch_){
        setCargoNumbers(0);
        setCustomerNumbers(0);
        setBranchNumbers(1);
        customers = new Customers[50];
        branch = new String[10];
        setBranch(branch_);
    }
    public CargoCompany(Customers obje){
        int cargoNumbers_ = obje.getCargoNumbers();
        int customerNumbers_ = 1;
        setCargoNumbers(cargoNumbers_);
        setCustomerNumbers(customerNumbers_);
        setBranchNumbers(0);
        customers = new Customers[50];
        setCustomers(obje);
        branch = new String[10];
    }
    public void setCustomers(Customers obje){
        customers[customerNumbers] = obje;
        customerNumbers++;
    }
    public Customers getCustomers(int num){
        return customers[num];
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
    public void setBranch(String name){
        branch[branchNumbers] = name;
        branchNumbers++;
    }
    public String getBranch(int num){
        return branch[num];
    }
    public void setBranchNumbers(int num){
        branchNumbers = num;
    }
    public int getBranchNumbers(){
        return branchNumbers;
    }
    public String toString(){
        return String.format("%s\n","Cargo Company");
    }
}
