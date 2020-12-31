import java.util.ArrayList;
import java.util.List;
/**
 * This class include name and packages
 * A customer may have more than one cargo.
 * So, this class has a cargo array.
 */
public class Customer{
    private String name_surname;
    private int cargoNumbers;
    List<Cargo> cargo;
    public Customer(){
        setName_surname("\0");
        setCargoNumbers(0);
        cargo = new ArrayList<>();
    }
    public Customer(String name_surname){
        setName_surname(name_surname);
        setCargoNumbers(0);
        cargo = new ArrayList<>();
    }
    public Customer(String name_surname1,Cargo obje){
        setName_surname(name_surname1);
        setCargoNumbers(1);
        cargo = new ArrayList<>();
        setCargo(obje);
    }
    public void setName_surname(String name_surname1){
        name_surname = name_surname1;
    }
    public String getName_surname(){
        return name_surname;
    }
    public void setCargoNumbers(int num){
        if(num < 50)
            cargoNumbers = num;
        else
            System.out.println("Wrong entry");
    }
    public int getCargoNumbers(){
        return cargoNumbers;
    }
    public void setCargo(Cargo newCargo){
        cargo.add(newCargo);
        cargoNumbers++;
    }
    public Cargo getCargo(int num){
        return cargo.get(num);
    }
    public void printCargo(String trackNum){
        int flag = 0;
        for(int i=0;i<cargoNumbers;i++){
            if(cargo.get(i).getTrackingNumber().equals(trackNum))
                flag = i;
        }
        System.out.println("***Shipping information that the customer wants to see***");
        System.out.printf("Sender name and surname: %s\n", cargo.get(flag).getSenderNameSurname());
        System.out.printf("Receiver name and surname: %s\n", cargo.get(flag).getReceiverNameSurname());
        System.out.printf("Current Status: %s\n", cargo.get(flag).getStatus());
    }
    public String toString(){
        return String.format("Customer name and surname: %s",getName_surname());
    }
}
