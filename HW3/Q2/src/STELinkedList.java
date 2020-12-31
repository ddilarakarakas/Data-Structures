import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class STELinkedList implements SimpleTextEditor{
    LinkedList<Character> data;
    int sizeNode;
    public STELinkedList(){
        data = new LinkedList<>();
        sizeNode = 0;
    }
    public STELinkedList(Character a){
        data = new LinkedList<>();
        data.set(0,a);
        sizeNode = 1;
    }
    public void setSizeNode(int sizeNode) {
        this.sizeNode = sizeNode;
    }
    public int getSizeNode() {
        return sizeNode;
    }
    /**
     *
     * @param name file name
     * @throws IOException if read() does not work.
     */
    @Override
    public void readFile(String name) throws IOException {
        FileReader fr = new FileReader(name);
        int i;
        while ((i=fr.read()) != -1){
            data.add(sizeNode,(char)i);
            sizeNode++;
        }
    }
    /**
     * Print for ArrayList data
     */
    public void print(){
        for(int i=0;i<sizeNode;i++){
            System.out.print(data.get(i));
        }
    }
    /**
     * Add method that adds one or more characters (given as a string)
     * at the specified position (given as an integer index)
     * in your text.
     * @param index that wants push word
     * @param word that wants push in text
     */
    @Override
    public void push(int index, String word) {
        int tempIndex = index - 1 ;
        for(int i=0;i<word.length();i++){
            data.add(tempIndex, word.charAt(i));
            sizeNode++;
            tempIndex++;
        }
    }
    /**
     * Find method that returns the start index of the
     * first occurrence of the searched group of characters.
     * @param word that wants to find
     * @return index
     */
    @Override
    public int search(String word) {
        boolean control =true;
        int index = 0;
        while(control){
            for(int i=0;i<sizeNode;i++){
                if(data.get(i).equals(word.charAt(0))){
                    index = i;
                    for(int j=1;j<word.length();j++){
                        if(data.get(j+i).equals(word.charAt(j)))
                            control = false;
                        else{
                            control = true;
                        }
                    }
                }
                if(!control)
                    i = sizeNode+4;
            }
        }
        return index;
    }
    /**
     * Replace method that replaces
     * all occurrences of a character with another character.
     * @param replace1 char one
     * @param replace2 char two
     */
    @Override
    public void replace(char replace1, char replace2){
        boolean control_t = false;
        for(int i=0;i<sizeNode;i++){
            control_t = false;
            if(data.get(i).equals(replace1)){
                data.set(i,replace2);
                control_t = true;
            }
            if(data.get(i).equals(replace2) && !control_t){
                data.set(i,replace1);
            }
        }
    }
    @Override
    public String toString() {
        return "STELinkedList{" +
                "data=" + data +
                ", sizeNode=" + sizeNode +
                '}';
    }
}