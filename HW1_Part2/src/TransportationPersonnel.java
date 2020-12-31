/**
 *  When the cargo is delivered, the transportation personnel makes the update.
 */
public class TransportationPersonnel extends CargoCompany implements Employee{
    private String name;
    public TransportationPersonnel(String name_){
        super();
        setName(name_);
    }
    public TransportationPersonnel(String name_,Customer customer){
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
    public void delivered(Cargo obje){
        obje.setStatus("Cargo deliverid!!");
    }
    public void printForTest(){
        System.out.println("Class TransportationPersonnel");
    }
    public String toString(){
        return String.format("%s\nTransportation name and surname: %s\n",super.toString(),getName());
    }
}
