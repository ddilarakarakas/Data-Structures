import java.io.IOException;

public interface SimpleTextEditor{
    void readFile(String name) throws IOException;
    //void writeFile(String name);
    void push(int index,String word);
    int search(String word);
    void replace(char replace1,char replace2);
}