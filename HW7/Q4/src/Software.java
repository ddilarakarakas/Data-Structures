public class Software implements Comparable<Software> {
    private String name;
    private String price;
    private int quantity;
    public Software(){
        name = null;
        price = null;
        quantity = 0;
    }
    public Software(String name,String price){
        this.name = name;
        this.price = price;
        quantity = 10;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Software{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                '}';
    }
    @Override
    public int compareTo(Software o) {
        return name.compareTo(o.name);
    }
}
