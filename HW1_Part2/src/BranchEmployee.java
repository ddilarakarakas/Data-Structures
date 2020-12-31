import java.util.NoSuchElementException;
/**
 * This class can enter and remove information about the shipments sent from that branch,
 * add and remove users (customers) to the system.
 * The information of the sender and receiver are recorded for each shipment.
 * When the package arrives at a branch or leaves the branch,
 * its current status is entered into the system by the branch employee.
 */
public class BranchEmployee extends CargoCompany implements Employee{
    String name;
    public BranchEmployee(String name_){
        super();
        setName(name_);
    }
    public BranchEmployee(String name_,Customer customer){
        super(customer);
        setName(name_);
    }
    @Override
    public void setName(String name_){
        name = name_;
    }
    @Override
    public String getName(){
        return name;
    }
    public void addCustomer(Customer newCustomer){
        boolean control = true;
        for(int i=0;i<customerNumbers;i++){
            if(customers.get(i).getName_surname().equals(newCustomer.getName_surname()))
                control = false;
        }
        if(control)
            setCustomers(newCustomer);
        else
            System.out.println("This customer is available");
    }
    public void removeCustomer(Customer deleteCustomer)throws NoSuchElementException{
        int delete = 0;
        boolean control = false;
        for(int i=0;i<customerNumbers;i++){
            if(customers.get(i).getName_surname().equals(deleteCustomer.getName_surname())){
                delete = i;
                control = true;
            }
        }
        if(control) {
            customers.remove(delete);
            customerNumbers--;
        }
    }
    public void addSenderCustomer(String nameSurname_,Cargo obje_){
        obje_.setSenderNameSurname(nameSurname_);
    }
    public void addReceiverCustomer(String nameSurname_,Cargo obje_){
        obje_.setReceiverNameSurname(nameSurname_);
    }
    public void updateTrackingNumber(String trackingNumber_,Cargo obje_){
        obje_.setTrackingNumber(trackingNumber_);
    }
    public void updateStatu(String statu,Cargo obje_){
        obje_.setStatus(statu);
    }
    public void printCustomers(){
        for(int i=0;i<customerNumbers;i++)
            System.out.printf("%d. Customer) %s\n",i+1, customers.get(i).getName_surname());
    }
    public void printForTest(){
        System.out.println("Class BranchEmployee");
    }
    public String toString(){
        return String.format("%s\n Branch Employee Name and Surname: %s",super.toString(),getName());
    }
}
