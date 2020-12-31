import java.util.NoSuchElementException;

public class WordLinkedList{
    private Node head = null;
    private Node tail = null;
    private String word;
    int current;
    public WordLinkedList(String word){
        head = new Node();
        tail = new Node();
        current = 0;
        for(int i=0;i<word.length();i++){
            if(i == 0){
                Node node = new Node(word.charAt(i));
                head.next = node;
                node.previous = head;
                node.next = tail;
                tail.previous = node;
                current++;
            }
            else{
                Node node = new Node(word.charAt(i));
                tail.previous.next = node;
                node.previous = tail.previous;
                node.next = tail;
                tail.previous = node;
                current++;
            }
        }
        this.word = word;
    }
    public Node getHead() {
        return head;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getWord() {
        return word;
    }
    public void setCurrent(int current) {
        this.current = current;
    }
    public int getCurrent() {
        return current;
    }
    public void removeCross(){
        WordLinkedListIterator iterator = new WordLinkedListIterator(head);
        while(iterator.hasNext()){
            if(iterator.nextNode.getCrossIndex() != -1){
                iterator.nextNode.cross = null;
                iterator.nextNode.crossIndex = -1;
            }
            if(iterator.hasNext())
                iterator.next();
        }
    }
    public void addCross(String word){
        WordLinkedListIterator iterator = new WordLinkedListIterator(head);
        WordLinkedList newWord = new WordLinkedList(word);
        WordLinkedListIterator iterator2 = new WordLinkedListIterator(newWord.head);
        boolean controlLoop = false;
        int control = 0;
        int cross1 = -1;
        int crossNew = 0;
        for(int i=0;i<newWord.getWord().length();i++){
            for(int j=0;j<getWord().length();j++){
                if(getWord().charAt(j) == newWord.getWord().charAt(i)){
                    cross1 = j;
                    crossNew = i;
                    controlLoop = true;
                    break;
                }
            }
            if(controlLoop)
                break;
        }
        int crossIndex1 = cross1;
        int crossIndex2 = crossNew;
        while(cross1 != 0){
            if(iterator.hasNext())
                iterator.next();
            cross1--;
        }
        while(crossNew != 0){
            if(iterator2.hasNext())
                iterator2.next();
            crossNew--;
        }
        iterator.nextNode.crossIndex = crossIndex1;
        iterator2.nextNode.crossIndex = crossIndex2;
        iterator.nextNode.cross = new Node();
        iterator2.nextNode.cross = new Node();
        iterator.nextNode.cross = iterator2.nextNode;
        iterator2.nextNode.cross = iterator.nextNode;
    }
    public void printWord(Node node_){
        WordLinkedListIterator iterator = new WordLinkedListIterator(node_);
        int controlLoop = 0;
        int crossNumber = 0;
        int tempCrossIndex;
        Node tempCrossNode = new Node();
        System.out.print(" \n");
        while(controlLoop != current){
            System.out.print(iterator.nextNode.data);
            if(iterator.nextNode.crossIndex != -1){
                crossNumber++;
            }
            if(iterator.hasNext())
                iterator.next();
            controlLoop++;
        }
        System.out.println("\nCross Words");
        if(crossNumber != 0){
            WordLinkedListIterator iterator2 = new WordLinkedListIterator(node_);
            int control2 = 0;
            while(control2 != current){
                if(crossNumber != 0){
                    if(iterator2.nextNode.crossIndex != -1){
                        System.out.print("Cross Index: " + iterator2.nextNode.crossIndex + " ");
                        tempCrossNode = iterator2.nextNode.cross;
                        WordLinkedListIterator controlIterator = new WordLinkedListIterator(tempCrossNode);
                        if(controlIterator.nextNode.previous.previous != head){
                            System.out.print(controlIterator.nextNode.previous.previous.data);
                        }
                        System.out.print(controlIterator.nextNode.previous.data);
                        System.out.print(controlIterator.nextNode.data);
                        while(controlIterator.nextNode.next != null){
                            if(controlIterator.nextNode.next != null ) {
                                controlIterator.next();
                            }
                            System.out.print(controlIterator.nextNode.data);

                        }
                        crossNumber--;
                    }
                }
                control2++;
                if(iterator2.hasNext()){
                    iterator2.next();
                }
            }
        }
    }
    /**
     * Inner class to for WordLinkedList
     */
    private class WordLinkedListIterator{
        private int index;
        private Node nextNode = null;
        private Node lastNodeReturned = null;
        public WordLinkedListIterator(Node head){
            setIndex(0);
            lastNodeReturned = new Node();
            nextNode = new Node();
            nextNode = head.next;
        }
        public void setNextNode(Node next) {
            this.nextNode = next;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public void setLastNodeReturned(Node previous) {
            this.lastNodeReturned = previous;
        }
        public int getIndex() {
            return index;
        }
        public Node getNextNode() {
            return nextNode;
        }
        public Node getLastNodeReturned() {
            return lastNodeReturned;
        }
        /**
         * Indicate whether movement forward is defined
         * @return true if call to next will not throw aan exception
         */
        public boolean hasNext(){
            return (nextNode.next != tail);
        }
        /**
         * Move the iterator forward and return the next Node
         * @return the next Node in the list
         */
        public Node next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastNodeReturned = nextNode;
            nextNode = nextNode.next;
            index++;
            return lastNodeReturned;
        }
        /**
         * Indicate whether movement backward is defined
         * @return true if call to previous will not throw an exception
         */
        public boolean hasPrevious(){
            return (nextNode == null && current != 0) || nextNode.previous != head;
        }
        /**
         * Move the iterator backward and return the previous Node
         * @return The previous Node in the list
         * @throws NoSuchElementException if there is no such object
         */
        public Node previous() {
            if(!hasPrevious())
                throw new NoSuchElementException();
            if(nextNode == null)
                nextNode = tail;
            else
                nextNode = nextNode.getPrevious();
            lastNodeReturned = nextNode;
            index--;
            return lastNodeReturned;
        }
        public int nextIndex() {
            return index+1;
        }
        public int previousIndex() {
            return index-1;
        }
        /**
         *Removes the last item returned from a call to next or previous.
         * If a call to remove is not preceded by a call to next or previous,
         * @throw IllegalStateException
         */
        public void remove() {
            if(lastNodeReturned == null || nextNode == null) {
                throw new IllegalStateException();
            } else{
                if(nextNode.previous == head){
                    lastNodeReturned.previous = head;
                    head.next = lastNodeReturned;
                    lastNodeReturned = lastNodeReturned.next;
                }
                else if(nextNode.next == tail){
                    tail.previous = lastNodeReturned;
                    lastNodeReturned.next = tail;
                    lastNodeReturned = lastNodeReturned.previous;
                }
                else{
                    lastNodeReturned.previous.next = nextNode;
                    nextNode.previous = lastNodeReturned.previous;
                    lastNodeReturned = lastNodeReturned.previous;
                }
                index--;
                current--;
            }
        }
        /**
         * Replace the last Node returned from a call to next or previous with obj.
         * If a call to set is not preceded by a call to next or previous,
         * @throw IllegalStateException
         */
        public void set(Node eNode) {
            if(lastNodeReturned == null || head == null){
                throw new IllegalStateException();
            } else{
                if(nextNode.previous == head){
                    head.next = eNode;
                    eNode.next = lastNodeReturned.next;
                    eNode.previous = head;
                    lastNodeReturned.next.previous = eNode;
                    lastNodeReturned = eNode;
                }
                else if(nextNode.next == tail){
                    tail.previous = eNode;
                    eNode.previous = lastNodeReturned.previous;
                    lastNodeReturned.previous.next = eNode;
                    eNode.next = tail;
                    lastNodeReturned = eNode;
                }
                else{
                    lastNodeReturned.next.previous = eNode;
                    eNode.next = lastNodeReturned.next;
                    eNode.previous = lastNodeReturned.previous;
                    lastNodeReturned.previous.next = eNode;
                    lastNodeReturned = eNode;
                }
            }
        }
        /**
         * Add a new Node between the Node that will be returned
         * by next and the Node that will be returned by previous
         * If previous is called after add, the element added is returned
         */
        public void add(Node eNode) {
            if(head.next == tail){
                //head = new Node<>();
                head.next = eNode;
                eNode.next = tail;
                tail.previous = eNode;
                eNode.previous = head;
            }
            else if(nextNode.previous == head){
                eNode.setNext(nextNode);
                nextNode.setPrevious(eNode);
                head = eNode;
            }
            else if(nextNode.next == tail){
                tail.setNext(eNode);
                eNode.setPrevious(tail);
                tail = eNode;
            }
            else{
                eNode.setPrevious(nextNode.getPrevious());
                nextNode.previous.next = eNode;
                eNode.setNext(nextNode);
                nextNode.setPrevious(eNode);
            }
            index++;
            lastNodeReturned = null;
        }
    }
    /**
     * Private Static Class Node include
     * char, Node next, Node previous, Node cross
     */
    private static class Node{
        private char data;
        private int crossIndex;
        private Node next = null;
        private Node previous = null;
        private Node cross = null;
        public Node(char c){
            data = c;
            crossIndex = -1;
        }
        public Node(){
            data = '\0';
            crossIndex = -1;
        }
        public Node newNode(Node node){
            Node node1 = new Node();
            node1.data = node.getData();
            node1.crossIndex = node.crossIndex;
            node1.next = node.next;
            node1.previous = node.previous;
            node1.cross = node.cross;
            return node1;
        }
        public void setCross(Node cross) {
            this.cross = cross;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public void setPrevious(Node previous) {
            this.previous = previous;
        }
        public void setData(char c) {
            this.data = c;
        }
        public Node getNext() {
            return next;
        }
        public Node getPrevious() {
            return previous;
        }
        public Node getCross() {
            return cross;
        }
        public char getData() {
            return data;
        }
        public int getCrossIndex() {
            return crossIndex;
        }
    }
}