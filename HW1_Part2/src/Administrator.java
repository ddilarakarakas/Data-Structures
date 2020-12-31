import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * This class manage the system by adding and removing branches,
 * branch employees and transportation personnel.
 */
public class Administrator extends CargoCompany{
    private int branchEmployeeNumbers;
    private int transportationPersonelNumbers;
    private int branchNumbers;
    private List<Branch> branches;
    private List<BranchEmployee> branchEmployees;
    private List<TransportationPersonnel> transportationPersonnels;
    public Administrator(){
        super();
        setBranchEmployeeNumbers(0);
        setTransportationPersonelNumbers(0);
        setBranchNumbers(0);
        branches = new ArrayList<>();
        branchEmployees = new ArrayList<>();
        transportationPersonnels = new ArrayList<>();
    }
    public Administrator(Branch B, BranchEmployee Be,TransportationPersonnel T){
        super();
        setBranchEmployeeNumbers(1);
        setTransportationPersonelNumbers(1);
        setBranchNumbers(1);
        branches = new ArrayList<>();
        branchEmployees = new ArrayList<>();
        transportationPersonnels = new ArrayList<>();
        setBranch(B);
        setBranchEmployees(Be);
        setTransportationPersonnels(T);
    }
    public void setBranch(Branch newBranch){
        branches.add(newBranch);
        branchNumbers++;
    }
    public void setBranchNumbers(int num){
        branchNumbers = num;
    }
    public int getBranchNumbers(){
        return branchNumbers;
    }
    public Branch getBrunch(int n){
        return branches.get(n);
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
    public void setBranchEmployees(BranchEmployee newBE){
        branchEmployees.add(newBE);
        branchEmployeeNumbers++;
    }
    public BranchEmployee getBrancEmployees(int num){
        return branchEmployees.get(num);
    }
    public void setTransportationPersonnels(TransportationPersonnel newTS){
        transportationPersonnels.add(newTS);
        transportationPersonelNumbers++;
    }
    public TransportationPersonnel getTransportationPersonel(int num){
        return transportationPersonnels.get(num);
    }
    public void addBranch(Branch newBranch){
        boolean control = true;
        for(int i=0;i<branchNumbers;i++){
            if(branches.get(i).getBranchName().equals(newBranch.getBranchName()))
                control = false;
        }
        if(control)
            setBranch(newBranch);
        else
            System.out.println("This branch is available");
    }
    public void removeBranch(Branch deleteBranch)throws NoSuchElementException {
        int delete = 0;
        boolean control = false;
        for(int i=0;i<branchNumbers;i++) {
            if (branches.get(i).getBranchName().equals(deleteBranch.getBranchName())) {
                delete = i;
                control = true;

            }
        }
        if(control){
            branches.remove(delete);
            branchNumbers--;
        }
    }
    public void addBranchEmployee(BranchEmployee newBranchEmployee){
        boolean control = true;
        for(int i=0;i<branchEmployeeNumbers;i++){
            if(branchEmployees.get(i).getName().equals(newBranchEmployee.getName()))
                control = false;
        }
        if(control)
            setBranchEmployees(newBranchEmployee);
        else
            System.out.println("This branch employee is available");
    }
    public void addTransportationPersonel(TransportationPersonnel newTP){
        boolean control = true;
        for(int i=0;i<transportationPersonelNumbers;i++){
            if(transportationPersonnels.get(i).getName().equals(newTP.getName()))
                control = false;
        }
        if(control)
            setTransportationPersonnels(newTP);
        else
            System.out.println("This transportation personnel is available");
    }
    public void removeTransportationEmployee(TransportationPersonnel deleteTP)throws NoSuchElementException{
        int delete = 0;
        boolean control = false;
        for(int i=0;i<transportationPersonelNumbers;i++) {
            if (transportationPersonnels.get(i).getName().equals(deleteTP.getName())) {
                delete = i;
                control = true;

            }
        }
        if(control){
            transportationPersonnels.remove(delete);
            transportationPersonelNumbers--;
        }
    }
    public void removeBrancEmployees(BranchEmployee deleteBranchEmployee)throws NoSuchElementException{
        int delete = 0;
        boolean control = false;
        for(int i=0;i<branchEmployeeNumbers;i++) {
            if (branchEmployees.get(i).getName().equals(deleteBranchEmployee.getName())) {
                delete = i;
                control = true;

            }
        }
        if(control){
            branchEmployees.remove(delete);
            branchEmployeeNumbers--;
        }
    }
    public void printBranch(){
        for(int i=0;i<branchNumbers;i++)
            System.out.printf("%d. Branch) %s\n",i+1, branches.get(i).getBranchName());
    }
    public void printBranchEmployees(){
        for(int i=0;i<branchEmployeeNumbers;i++)
            System.out.printf("%d. Branch Employee) %s\n",i+1,branchEmployees.get(i).getName());
    }
    public void printTransportationPersonnel(){
        for(int i=0;i<transportationPersonelNumbers;i++)
            System.out.printf("%d. Transportation Personel) %s\n",i+1,transportationPersonnels.get(i).getName());
    }
    public void printForTest(){
        System.out.println("Class Administrator");
    }
    public String toString(){
        return String.format("%s\nCompany has %d branch %d branch employees and %d transportation personnel\n",super.toString()
                ,getBranchNumbers()
                ,getBranchEmployeeNumbers()
                ,getTransportationPersonelNumbers());
    }
}
