/**
 * This class include senderNameSurname, receiverNameSurname,
 * trackingNumber and status.
 */
public class Cargo{
    private String senderNameSurname;
    private String receiverNameSurname;
    private String trackingNumber;
    private String status;
    public Cargo(){
        setSenderNameSurname("\0");
        setReceiverNameSurname("\0");
        setTrackingNumber("\0");
        setStatus("\0");
    }
    public Cargo(String sender,String receiver,String num,String s){
        setSenderNameSurname(sender);
        setReceiverNameSurname(receiver);
        setTrackingNumber(num);
        setStatus(s);
    }
    public String getSenderNameSurname(){
        return senderNameSurname;
    }
    public void setSenderNameSurname(String senderNameSurname) {
        this.senderNameSurname = senderNameSurname;
    }
    public String getReceiverNameSurname(){
        return receiverNameSurname;
    }
    public void setReceiverNameSurname(String receiver){
        receiverNameSurname = receiver;
    }
    public String getTrackingNumber(){
        return trackingNumber;
    }
    public void setTrackingNumber(String num){
        trackingNumber = num;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String s){
        status = s;
    }
    public String toString(){
        return String.format("Sender Name and Surname: %s\nReceiver Name and Surname: %s\nTracking Number: %s\nCurrent Status: %s\n",getSenderNameSurname(),
                            getReceiverNameSurname()
                            ,getTrackingNumber()
                            ,getStatus());
    }

}
