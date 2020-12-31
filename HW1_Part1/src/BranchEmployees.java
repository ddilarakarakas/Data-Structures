/**
 * This class can enter and remove information about the shipments sent from that branch,
 * add and remove users (customers) to the system.
 * The information of the sender and receiver are recorded for each shipment.
 * When the package arrives at a branch or leaves the branch,
 * its current status is entered into the system by the branch employee.
 */
public class BranchEmployees extends CargoCompany {
    private String name;
    public BranchEmployees(String name_){
        super();
        setName(name_);
    }
    public BranchEmployees(String name_,Customers obje){
        super(obje);
        setName(name_);
    }
    public void setName(String name1){
        name = name1;
    }
    public String getName(){
        return name;
    }
    public void addCustomer(Customers newObje){
        boolean control = true;
        if(customerNumbers < 50){
            for(int i=0;i<customerNumbers;i++){
                if(customers[i].getName_surname().equals(newObje.getName_surname()))
                    control = false;
            }
            if(control)
                setCustomers(newObje);
            else
                System.out.println("This customer is available");
        }
        else
            System.out.println("Company customer quota is full!");
    }
    public void removeCustomer(Customers deleteObje){
        int delete = 0;
        boolean control = false;
        for(int i=0;i<customerNumbers;i++){
            if(customers[i].getName_surname().equals(deleteObje.getName_surname())){
                delete = i;
                control = true;
            }
        }
        if(control){
            for(int i=delete;i<customerNumbers-1;i++)
                customers[i] = customers[i+1];
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
            System.out.printf("%d. Customer) %s\n",i+1,customers[i].getName_surname());
    }
    public String toString(){
        return String.format("%s\n Branch Employee Name and Surname: %s",super.toString(),getName());
    }
}
