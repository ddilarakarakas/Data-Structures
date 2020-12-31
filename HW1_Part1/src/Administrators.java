/**
 * This class manage the system by adding and removing branches,
 * branch employees and transportation personnel.
 */
public class Administrators extends CargoCompany{
    private int branchEmployeeNumbers;
    private int transportationPersonelNumbers;
    private BranchEmployees[] branchEmployees;
    private TransportationPersonnel[] transportationPersonnels;
    public Administrators(){
        super();
        setBranchEmployeeNumbers(0);
        setTransportationPersonelNumbers(0);
        branchEmployees = new BranchEmployees[10];
        transportationPersonnels = new TransportationPersonnel[10];
    }
    public Administrators(String branchName,BranchEmployees objeB,TransportationPersonnel objeT){
        super(branchName);
        setBranchEmployeeNumbers(1);
        setTransportationPersonelNumbers(1);
        branchEmployees = new BranchEmployees[10];
        transportationPersonnels = new TransportationPersonnel[10];
        setBranchEmployees(objeB);
        setTransportationPersonnels(objeT);
    }
    public void setBranchEmployeeNumbers(int number){
        branchEmployeeNumbers = number;
    }
    public void setTransportationPersonelNumbers(int number){
        transportationPersonelNumbers = number;
    }
    public int getBranchEmployeeNumbers(){
        return branchEmployeeNumbers;
    }
    public int getTransportationPersonelNumbers(){
        return transportationPersonelNumbers;
    }
    public void setBranchEmployees(BranchEmployees obje){
        branchEmployees[branchEmployeeNumbers] = obje;
        branchEmployeeNumbers++;
    }
    public BranchEmployees getBrancEmployees(int num){
        return branchEmployees[num];
    }
    public void setTransportationPersonnels(TransportationPersonnel obje){
        transportationPersonnels[transportationPersonelNumbers] = obje;
        transportationPersonelNumbers++;
    }
    public TransportationPersonnel getTransportationPersonel(int num){
        return transportationPersonnels[num];
    }
    public void addBranch(String newBranch){
        if(branchNumbers < 10)
            setBranch(newBranch);
        else
            System.out.println("There are enough brunches");
    }
    public void removeBranch(String deleteBranch){
        int delete = 0;
        boolean control = false;
        for(int i=0;i<branchNumbers;i++) {
            if (branch[i].equals(deleteBranch)) {
                delete = i;
                control = true;

            }
        }
        if(control){
            for(int i=delete;i<branchNumbers-1;i++)
                branch[i] = branch[i+1];
            branchNumbers--;
        }
        else
            System.out.println("This branch does not exist!!!");
    }
    public void addBranchEmployee(BranchEmployees newObje){
        if(branchEmployeeNumbers < 10)
            setBranchEmployees(newObje);
        else
            System.out.println("There are enough branch employees!!");
    }
    public void addTransportationPersonel(TransportationPersonnel newObje){
        if(transportationPersonelNumbers < 10)
            setTransportationPersonnels(newObje);
        else
            System.out.println("There are enough transportation personnel!!");
    }
    public void removeTransportationEmployee(TransportationPersonnel deleteObje){
        int delete = 0;
        boolean control = false;
        for(int i=0;i<transportationPersonelNumbers;i++){
            if(transportationPersonnels[i].getName().equals(deleteObje.getName())){
                delete = i;
                control = true;
            }
        }
        if(control){
            for(int i=delete;i<transportationPersonelNumbers-1;i++)
                transportationPersonnels[i] = transportationPersonnels[i+1];
            transportationPersonelNumbers--;
        }
        else
            System.out.println("This transportation personnel does not exist!!!");
    }
    public void removeBrancEmployees(BranchEmployees deleteObje){
        int delete = 0;
        boolean control = false;
        for(int i=0;i<branchEmployeeNumbers;i++){
            if(branchEmployees[i].getName().equals(deleteObje.getName())){
                delete = i;
                control = true;
            }
        }
        if(control){
            for(int i=delete;i<branchEmployeeNumbers-1;i++)
                branchEmployees[i] = branchEmployees[i+1];
            branchEmployeeNumbers--;
        }
        else
            System.out.println("This branch employee does not exist!!!");
    }
    public void printBranch(){
        for(int i=0;i<branchNumbers;i++)
            System.out.printf("%d. Branch) %s\n",i+1,branch[i]);
    }
    public void printBranchEmployees(){
        for(int i=0;i<branchEmployeeNumbers;i++)
            System.out.printf("%d. Branch Employee) %s\n",i+1,branchEmployees[i].getName());
    }
    public void printTransportationPersonnel(){
        for(int i=0;i<transportationPersonelNumbers;i++)
            System.out.printf("%d. Transportation Personel) %s\n",i+1,transportationPersonnels[i].getName());
    }
    public String toString(){
        return String.format("%s\nCompany has %d branch employees and %d transportation personnel\n",super.toString()
                ,getBranchEmployeeNumbers()
                ,getTransportationPersonelNumbers());
    }
}
