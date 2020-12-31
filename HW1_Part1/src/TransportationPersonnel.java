/**
 *  When the cargo is delivered, the transportation personnel makes the update.
 */
public class TransportationPersonnel extends CargoCompany {
    private String name;
    public TransportationPersonnel(String name_){
        super();
        setName(name_);
    }
    public TransportationPersonnel(String name_,Customers obje){
        super(obje);
        setName(name_);
    }
    public void setName(String name_){
        name = name_;
    }
    public String getName(){
        return name;
    }
    public void delivered(Cargo obje){
        obje.setStatus("Cargo deliverid!!");
    }
    public String toString(){
        return String.format("%s\nTransportation name and surname: %s\n",super.toString(),getName());
    }
}
