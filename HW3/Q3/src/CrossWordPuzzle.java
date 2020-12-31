import java.util.LinkedList;
public class CrossWordPuzzle {
    LinkedList<WordLinkedList> words;
    int wordsNumber;
    public CrossWordPuzzle(){
        words = new LinkedList<>();
        wordsNumber = 0;
    }
    public CrossWordPuzzle(String word){
        WordLinkedList newWord = new WordLinkedList(word);
        words = new LinkedList<>();
        words.add(newWord);
        wordsNumber = 1;
    }
    public int getWordsNumber() {
        return wordsNumber;
    }
    public void setWordsNumber(int wordsNumber) {
        this.wordsNumber = wordsNumber;
    }
    public void addWord(String word){
        boolean control = false;
        int indexWordTemp = -1;
        WordLinkedList newWord = new WordLinkedList(word);
        for(int i=0;i<wordsNumber;i++) {
            for (int j = 0; j < words.get(i).getWord().length(); j++) {
                char c = words.get(i).getWord().charAt(j);
                for (int k = 0; k < word.length(); k++) {
                    char n = word.charAt(k);
                    if (c == n) {
                        indexWordTemp = i;
                        control = true;
                        k = 100000;
                        j = 100000;
                    }
                }
            }
            if (control)
                i = 1000000;
        }
        if(indexWordTemp != -1){
            words.get(indexWordTemp).addCross(word);
        }
        words.add(newWord);
        wordsNumber++;
    }
    public void removeWord(String word){
        boolean control = false;
        int indexWordTemp = -1;
        WordLinkedList newWord = new WordLinkedList(word);
        for(int i=0;i<wordsNumber;i++){
            for(int j=0;j<words.get(i).getWord().length();j++){
                if(words.get(i).getWord().equals(word)){
                    indexWordTemp = i;
                    control = true;
                    j = words.get(i).getWord().length()+5;
                }
            }
            if(control)
                i = wordsNumber+4;
        }
        words.get(indexWordTemp).removeCross();
        words.remove(indexWordTemp);
        wordsNumber--;
    }
    public LinkedList<WordLinkedList> getWords() {
        return words;
    }
    public void print(){
        for(int i=0;i<words.size();i++){
            words.get(i).printWord(words.get(i).getHead());
        }
    }
}
