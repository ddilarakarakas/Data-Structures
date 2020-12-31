public  class Branch extends CargoCompany {
    private String branchName;
    public Branch(){
        setBranchName("\0");
    }
    public Branch(String name){
        setBranchName(name);
    }
    public String getBranchName(){
        return branchName;
    }
    public void setBranchName(String name){
        branchName = name;
    }
    public void printForTest(){
        System.out.println("Class Branch");
    }
    public String toString(){
        return String.format("%s \n Branch name: %s\n",super.toString(),getBranchName());
    }
}
