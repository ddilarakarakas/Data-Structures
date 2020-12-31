import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.File;
public class STEArrayListWithIterator implements SimpleTextEditor{
    private ArrayList<Character> data;
    int sizeNode;
    public STEArrayListWithIterator(){
        data = new ArrayList<>();
        sizeNode = 0;
    }
    public STEArrayListWithIterator(Character a){
        data = new ArrayList<>();
        data.set(0,a);
        sizeNode = 1;
    }
    public int getSizeNode() {
        return sizeNode;
    }
    public void setSizeNode(int sizeNode) {
        this.sizeNode = sizeNode;
    }
    /**
     * Print for ArrayList data
     */
    public void print(){
        ListIterator<Character> iterator = data.listIterator();
        while(iterator.hasNext()){
            if(iterator.hasNext())
                System.out.print(iterator.next());
        }
    }
    /**
     *
     * @param name file name
     * @throws IOException if read() does not work.
     */
    @Override
    public void readFile(String name) throws IOException{
        ListIterator<Character> iterator = data.listIterator();
        File f = new File(name);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int i;
        while ((i=br.read()) != -1){
            iterator.add((char)i);
            sizeNode++;
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
        ListIterator<Character> iterator = data.listIterator();
        int tempIndex = index - 1 ;
        while (tempIndex != 0) {
            if(iterator.hasNext())
                iterator.next();
            tempIndex--;
        }
        for(int i=0;i<word.length();i++){
            iterator.add(word.charAt(i));
            sizeNode++;
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
        ListIterator<Character> iterator = data.listIterator();
        boolean control =true;
        int index = 0;
        while(control){
            while (iterator.hasNext()){
                char ch = '0';
                if(iterator.hasNext()) {
                    ch = iterator.next();
                    index++;
                }
                if(word.charAt(0) == ch){

                    char controlChar = ch;
                    for(int i=0;i<word.length();i++){
                        if(controlChar == word.charAt(i)) {
                            control = false;
                        }
                        else {
                            control = true;
                        }
                        if(iterator.hasNext()){
                            controlChar = iterator.next();
                            index++;
                        }
                    }
                }
                if(!control){
                    break;
                }
            }
        }
        index = index - word.length() - 1;
        return index;
    }
    /**
     * Replace method that replaces
     * all occurrences of a character with another character.
     * @param replace1 char one
     * @param replace2 char two
     */
    @Override
    public void replace(char replace1, char replace2) {
        ListIterator<Character> iterator = data.listIterator();
        char ch_control = '0';
        boolean control_t = false;
        while(iterator.hasNext()){
            control_t = false;
            if(iterator.hasNext())
                ch_control = iterator.next();
            iterator.previous();
            if(ch_control == replace1){
                iterator.set(replace2);
                control_t = true;
            }
            if ((!control_t) && ch_control == replace2)
                iterator.set(replace1);
            if(iterator.hasNext())
                iterator.next();
        }
    }
    @Override
    public String toString() {
        return "STEArrayListWithIterator{" +
                "data=" + data +
                ", sizeNode=" + sizeNode +
                '}';
    }
}