/**
 * This class include name and packages
 * A customer may have more than one cargo.
 * So, this class has a cargo array.
 */
public class Customers{
    private String name_surname;
    private int cargoNumbers;
    private Cargo[] cargos;
    public Customers(){
        setName_surname("\0");
        setCargoNumbers(0);
        cargos = new Cargo[50];
    }
    public Customers(String name_surname){
        setName_surname(name_surname);
        setCargoNumbers(0);
        cargos = new Cargo[50];
    }
    public Customers(String name_surname1,Cargo obje){
        setName_surname(name_surname1);
        setCargoNumbers(1);
        cargos = new Cargo[50];
        setCargos(obje);
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
    public void setCargos(Cargo obje){
        if(cargoNumbers < 50){
            cargos[cargoNumbers] = obje;
            cargoNumbers++;
        }
        else
            System.out.println("Customer cannot have more cargo!");
    }
    public Cargo getCargos(int num){
        return cargos[num];
    }
    public void printCargo(String trackNum){
        int flag = 0;
        for(int i=0;i<cargoNumbers;i++){
            if(cargos[i].getTrackingNumber().equals(trackNum))
                flag = i;
        }
        System.out.println("***Shipping information that the customer wants to see***");
        System.out.printf("Sender name and surname: %s\n",cargos[flag].getSenderNameSurname());
        System.out.printf("Receiver name and surname: %s\n",cargos[flag].getReceiverNameSurname());
        System.out.printf("Current Status: %s\n",cargos[flag].getStatus());
    }
    public String toString(){
        return String.format("Customer name and surname: %s",getName_surname());
    }
}
