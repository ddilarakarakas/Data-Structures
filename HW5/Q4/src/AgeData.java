public class AgeData implements Comparable<AgeData> {
    private int age;
    private int ageNumber;
    public AgeData right;
    public AgeData left;
    public AgeData(int age_, int ageNumber_){
        setAge(age_);
        setAgeNumber(ageNumber_);
        right = null;
        left = null;
    }
    public AgeData(int age_){
        setAge(age_);
        setAgeNumber(1);
        right = null;
        left = null;
    }
    public AgeData(){
        setAge(-1);
        setAgeNumber(0);
        right = null;
        left = null;
    }
    public AgeData getLeft() {
        return left;
    }
    public AgeData getRight() {
        return right;
    }
    public void setLeft(AgeData left) {
        this.left = new AgeData();
        this.left = left;
    }
    public void setRight(AgeData right) {
        this.right = new AgeData();
        this.right = right;
    }
    public int getAge() {
        return age;
    }
    public int getAgeNumber() {
        return ageNumber;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAgeNumber(int ageNumber) {
        this.ageNumber = ageNumber;
    }
    @Override
    public int compareTo(AgeData o) {
        if(this.age == o.age)
            return 0;
        else if(this.age < o.age)
            return -1;
        else
            return 1;
    }
    @Override
    public String toString() {
        return age + " - " + ageNumber + '\n';
    }
}