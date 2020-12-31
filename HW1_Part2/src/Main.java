import java.util.NoSuchElementException;
/**
 *@author DilaraKarakas

 */
public class Main {
    public static void main(String[] args){
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("*******TEST FOR CARGO COMPANY*******");
        Administrator admin = new Administrator();
        BranchEmployee branchEmployee1 = new BranchEmployee("Louis Litt");
        BranchEmployee branchEmployee2 = new BranchEmployee("Jessica Pearson");
        TransportationPersonnel transportationPer1 = new TransportationPersonnel("Katrina Bennett");
        TransportationPersonnel transportationPer2 = new TransportationPersonnel("Daniel Hardman");
        Cargo cargo1 = new Cargo();
        Cargo cargo2 = new Cargo();
        Customer customers1 = new Customer();
        Customer customers2 = new Customer();
        customers1.setName_surname("Mike Ross");
        customers2.setName_surname("Harvey Specter");
        Branch branch1 = new Branch("New York");
        Branch branch2 = new Branch("Los Angeles");
        Branch branch3 = new Branch("Boston");
        System.out.println("*********************************************************");
        System.out.println("*****->TEST FOR ADMINISTRATORS<-*****");
        System.out.println("**->TEST FOR ADD NEW YORK BRANCH<-**");
        admin.addBranch(branch1);
        admin.printBranch();
        System.out.println("**->TEST FOR ADD LOS ANGELES BRANCH<-**");
        admin.addBranch(branch2);
        admin.printBranch();
        System.out.println("**->TEST FOR REMOVE LOS ANGELES BRANCH<-**");
        try{
            admin.removeBranch(branch2);
            admin.printBranch();
        }
        catch (NoSuchElementException e){
            System.out.println("Exception in Administrators Test");
        }
        System.out.println("**->TEST FOR ADD BOSTON BRANCH<-**");
        admin.addBranch(branch3);
        admin.printBranch();
        System.out.println("**->TEST FOR REMOVE NEW YORK BRANCH<-**");
        try{
            admin.removeBranch(branch1);
            admin.printBranch();
        }
        catch (NoSuchElementException e){
            System.out.println("Exception in Administrators Test");
        }
        System.out.println("**->TEST FOR ADD FIRST BRANCH EMPLOYEE<-**");
        admin.addBranchEmployee(branchEmployee1);
        admin.printBranchEmployees();
        System.out.println("**->TEST FOR ADD SECOND BRANCH EMPLOYEE<-**");
        admin.addBranchEmployee(branchEmployee2);
        admin.printBranchEmployees();
        System.out.println("**->TEST FOR REMOVE FIRST BRANCH EMPLOYEE<-**");
        try{
            admin.removeBrancEmployees(branchEmployee1);
            admin.printBranchEmployees();
        }
        catch (NoSuchElementException e){
            System.out.println("Exception in Administrators Test");
        }
        System.out.println("**->TEST FOR ADD FIRST TRANSPORTATION PERSONNEL<-**");
        admin.addTransportationPersonel(transportationPer1);
        admin.printTransportationPersonnel();
        System.out.println("**->TEST FOR ADD SECOND TRANSPORTATION PERSONNEL<-**");
        admin.addTransportationPersonel(transportationPer2);
        admin.printTransportationPersonnel();
        System.out.println("**->TEST FOR REMOVE FIRST TRANSPORTATION PERSONNEL<-**");
        try{
            admin.removeTransportationEmployee(transportationPer1);
            admin.printTransportationPersonnel();
        }
        catch (NoSuchElementException e){
            System.out.println("Exception in Administrators Test");
        }
        System.out.println("*********************************************************");
        System.out.println("*****->TEST FOR BRANCH EMPLOYEES<-*****");
        System.out.println("**->TEST FOR ADD FIRST CUSTOMER<-**");
        branchEmployee1.addCustomer(customers1);
        branchEmployee1.printCustomers();
        System.out.println("**->TEST FOR ADD SECOND CUSTOMER<-**");
        branchEmployee1.addCustomer(customers2);
        branchEmployee1.printCustomers();
        System.out.println("**->TEST FOR REMOVE FIRST CUSTOMER<-**");
        try{
            branchEmployee1.removeCustomer(customers1);
            branchEmployee1.printCustomers();
        }
        catch (NoSuchElementException e){
            System.out.println("Exception in Branch Employee Test");
        }
        System.out.println("**->TEST FOR ADD SENDER CUSTOMER(RACHEL ZANE) IN FIRST CARGO INFORMATION<-**");
        branchEmployee1.addSenderCustomer("Rachel Zane",cargo1);
        System.out.printf("%s",cargo1.toString());
        System.out.println("**->TEST FOR ADD RECEIVER CUSTOMER(MIKE ROSS) IN FIRST CARGO INFORMATION<-**");
        branchEmployee1.addReceiverCustomer("Mike Ross",cargo1);
        System.out.printf("%s",cargo1.toString());
        System.out.println("**->TEST FOR UPDATE TRACKING NUMBER IN FIRST CARGO INFORMATION<-**");
        branchEmployee1.updateTrackingNumber("201 032 021",cargo1);
        System.out.printf("%s",cargo1.toString());
        System.out.println("**->TEST FOR UPDATE STATUS IN FIRST CARGO INFORMATION<-**");
        branchEmployee1.updateStatu("Cargo is a branch",cargo1);
        System.out.printf("%s",cargo1.toString());
        System.out.println("**->TEST FOR UPDATE STATU IN FIRST CARGO INFORMATION<-**");
        branchEmployee1.updateStatu("Cargo is in distribution",cargo1);
        System.out.printf("%s",cargo1.toString());
        System.out.println("**->TEST FOR ADD SENDER CUSTOMER(RACHEL ZANE) IN SECOND CARGO INFORMATION<-**");
        branchEmployee1.addSenderCustomer("Donna Paulsen",cargo2);
        System.out.printf("%s",cargo2.toString());
        System.out.println("**->TEST FOR ADD RECEIVER CUSTOMER(MIKE ROSS) IN SECOND CARGO INFORMATION<-**");
        branchEmployee1.addReceiverCustomer("Harvey Specter",cargo2);
        System.out.printf("%s",cargo2.toString());
        System.out.println("**->TEST FOR UPDATE TRACKING NUMBER IN SECOND CARGO INFORMATION<-**");
        branchEmployee1.updateTrackingNumber("567 778 456",cargo2);
        System.out.printf("%s",cargo2.toString());
        System.out.println("**->TEST FOR UPDATE STATUS IN SECOND CARGO INFORMATION<-**");
        branchEmployee1.updateStatu("Cargo is a branch",cargo2);
        System.out.printf("%s",cargo2.toString());
        System.out.println("**->TEST FOR UPDATE STATUS IN SECOND CARGO INFORMATION<-**");
        branchEmployee1.updateStatu("Cargo is in distribution",cargo2);
        System.out.printf("%s",cargo2.toString());
        System.out.println("*********************************************************");
        System.out.println("*****->TEST FOR TRANSFORMATION PERSONNEL<-*****");
        System.out.println("**->TEST FOR UPDATE STATUS IN CARGO INFORMATION<-**");
        transportationPer1.delivered(cargo1);
        System.out.printf("%s",cargo1.toString());
        System.out.println("*********************************************************");
        System.out.println("*****->TEST FOR CUSTOMERS<-*****");
        customers1.setCargo(cargo1);
        customers2.setCargo(cargo2);
        System.out.printf("1. Customer's Cargo(Tracking Number: %s)\n",cargo1.getTrackingNumber());
        customers1.printCargo(cargo1.getTrackingNumber());
        System.out.printf("2. Customer's Cargo(Tracking Number: %s)\n",cargo2.getTrackingNumber());
        customers2.printCargo(cargo2.getTrackingNumber());
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
    }
}
