import java.util.*;

public class LinkedArrayList<E> extends AbstractList<E>{
    private int size;
    private int current;
    private Node<E> head;
    private Node<E> tail;

    /**
     * A node is the  building block for a LinkedArrayList
     * @param <E>
     */
    private static class Node<E>{
        private int size;
        private int capacity;
        /**
         * The reference to the data[]
         */
        private E [] data;
        private Node<E> next;
        private Node<E> previous;
        @SuppressWarnings("unchecked")
        public Node(){
            setSize(0);
            setCapacity(5);
            this.data = (E[]) new Object[6];
         //   next = new Node<>();
          //  previous = new Node<>();
            next = null;
            previous = null;
        }
        @SuppressWarnings("unchecked")
        public Node(E data_){
            setSize(0);
            setCapacity(5);
            this.data = (E[]) new Object[5];
            addData(data_);
           // next = new Node<>();
           // previous = new Node<>();
            next = null;
            previous = null;
        }
        @SuppressWarnings("unchecked")
        public Node(E [] data_, int size_){
            setSize(size_);
            setCapacity(5);
            this.data = (E[]) new Object[5];
            next = new Node<>();
            previous = new Node<>();
            setData(data_);
            next = null;
            previous = null;
        }
        public void setSize(int size_){
            this.size = size_;
        }
        public void setCapacity(int capacity_){
            this.capacity = capacity_;
        }
        public void setData(E[] data) {
            this.data = data;
        }
        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public int getSize(){
            this.size = 0;
            for(int i=0;i<capacity;i++){
                if(data[i] != null)
                    size++;
            }
            return this.size;
        }
        public int getCapacity(){
            return this.capacity;
        }
        public E getData(int index){
            return this.data[index];
        }
        public E[] getData() {
            return data;
        }
        public Node<E> getPrevious() {
            return previous;
        }
        public Node<E> getNext() {
            return next;
        }
        /**
         * If size < capacity, adding data.
         */
        public void addData(E data_){
            if(size < capacity ){
                this.data[size] = data_;
                size++;
            }
            else
                System.out.println("Not Enough Capacity");
        }
        public void removeData(E data_){
            int delete_index = 0;
            boolean control = false;
            if(size > 0){
                for(int i=0;i<size;i++){
                    if(data_ == data[i]){
                        control = true;
                        delete_index = i;
                    }
                }
                if(control){
                    for(int i=0;i<size;i++){
                        if(i == delete_index){
                            for(int j=i;j<size-1;j++){
                                data[j] = data[j+1];
                            }
                            size = size - 1;
                        }
                    }
                }
                else{
                    System.out.println("There is no data. TRY AGAIN!!");
                }
            }
        }
        @Override
        public String toString() {
            return "Node{" +
                    "size=" + size +
                    ", capacity=" + capacity +
                    ", data=" + Arrays.toString(data) +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * Inner class to implement the ListIterator interface
     */
    private class LinkedArrayListIterator implements ListIterator<Node<E>> {
        private int index;
        private Node<E> nextNode = null;
        private Node<E> lastNodeReturned = null;
        //private T [] nextData;
        //private T [] lastDataReturned
        public LinkedArrayListIterator(Node<E> head){
            setIndex(1);
            lastNodeReturned = new Node<>();
            nextNode = new Node<>();
            nextNode = head.next;
        }
        public void setNextNode(Node<E> next) {
            this.nextNode = next;
        }
        public void setIndex(int index) {
            this.index = index;
        }
        public void setLastNodeReturned(Node<E> previous) {
            this.lastNodeReturned = previous;
        }
        public int getIndex() {
            return index;
        }
        public Node<E> getNextNode() {
            return nextNode;
        }
        public Node<E> getLastNodeReturned() {
            return lastNodeReturned;
        }
        /**
         * Indicate whether movement forward is defined
         * @return true if call to next will not throw aan exception
         */
        @Override
        public boolean hasNext(){
            return (nextNode.next != tail);
        }
        /**
         * Move the iterator forward and return the next Node
         * @return the next Node in the list
         * @throws java.util.NoSuchElementException if there is no such object
         */
        @Override
        public Node<E> next() {
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
        @Override
        public boolean hasPrevious(){
            return (nextNode == null && current != 0) || nextNode.previous != head;
        }
        /**
         * Move the iterator backward and return the previous Node
         * @return The previous Node in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public Node<E> previous() {
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
        @Override
        public int nextIndex() {
            return index+1;
        }
        @Override
        public int previousIndex() {
            return index-1;
        }
        /**
         *Removes the last item returned from a call to next or previous.
         * If a call to remove is not preceded by a call to next or previous,
         * @throw IllegalStateException
         */
        @Override
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
        @Override
        public void set(Node<E> eNode) {
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
        @Override
        public void add(Node<E> eNode) {
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
            size++;
            index++;
            lastNodeReturned = null;
        }
        @Override
        public String toString() {
            return "LinkedArrayListIterator{" +
                    "index=" + index +
                    ", head=" + head +
                    ", nextNode=" + nextNode +
                    ", lastNodeReturned=" + lastNodeReturned +
                    '}';
        }
    }

    public LinkedArrayList(){
        setSize(20);
        setCurrent(1);
        Node<E> eNode = new Node<>();
        head = new Node<>();
        tail = new Node<>();
        head.next = new Node<>();
        head.next = eNode;
        tail.previous = new Node<>();
        tail.previous = eNode;
        eNode.next = tail;
        eNode.previous = head;
        tail.next = null;
        head.previous = null;
    }
    public LinkedArrayList(E data){
        Node<E> obj = new Node<>(data);
        setSize(20);
        setCurrent(1);
        head = new Node<>();
        tail = new Node<>();
        head.next = new Node<>();
        head.next = obj;
        obj.previous = head;
        head.previous = null;
        obj.next = tail;
        tail.previous = new Node<>();
        tail.previous = obj;
        tail.next = null;
    }
    public LinkedArrayList(E [] data,int size){
        Node<E> obj = new Node<>(data,size);
        setSize(20);
        setCurrent(1);
        head = new Node<>();
        tail = new Node<>();
        head.next = new Node<>();
        head.next = obj;
        obj.previous = head;
        head.previous = null;
        obj.next = tail;
        tail.previous = new Node<>();
        tail.previous = obj;
        tail.next = null;
    }
    public LinkedArrayList(Node<E> obj){
        setSize(20);
        setCurrent(1);
        head = new Node<>();
        tail = new Node<>();
        head.next = new Node<>();
        head.next = obj;
        obj.previous = head;
        head.previous = null;
        obj.next = tail;
        tail.previous = new Node<>();
        tail.previous = obj;
        tail.next = null;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setHead(Node<E> head) {
        this.head = head;
    }
    public void setTail(Node<E> tail) {
        this.tail = tail;
    }
    public void setCurrent(int current){
        this.current = current;
    }
    public int getSize() {
        return size;
    }
    public int getCurrent() {
        return current;
    }
    public Node<E> getTail() {
        return tail;
    }
    public Node<E> getHead() {
        return head;
    }
    @SuppressWarnings("unchecked")
    public void removeData(E data){
        int nodeIndex = 1;
        int temp_index = 0;
        boolean control = true;
        boolean controlIndex = false;
        LinkedArrayListIterator iter = new LinkedArrayListIterator(head);
        while(control){
            for(int i=0;i<iter.nextNode.getSize();i++){
                if(iter.nextNode.getData(i).equals(data)){
                    temp_index = i;
                    controlIndex = true;
                    i = 56;
                }
            }
            if(controlIndex)
                control = false;
            else{
                if(iter.hasNext()){
                    iter.next();
                    nodeIndex++;
                    temp_index = 0;
                }
                else{
                    control = false;
                }
            }
        }
        if(controlIndex){
            for(int i=temp_index;i<iter.nextNode.getSize()-1;i++){
                iter.nextNode.data[i] = iter.nextNode.data[i +1];
            }
            iter.nextNode.data[iter.nextNode.getSize()-1] = null;
            boolean controlNull = false;
            for(int i=0;i<iter.nextNode.getSize();i++){
                if(iter.nextNode.data[i] != null)
                    controlNull = true;
            }
            if(!controlNull){
                iter.remove();
            }
        }else
            System.out.println("Data is not avaible!!");
    }
    public void pushNode(E []arr,int size){
        boolean control = false;
        for(int i=0;i<head.next.getCapacity();i++){
            if(head.next.data[i] != null)
                control = true;
        }
        if(control){
            Node<E> eNode = new Node<>(arr,size);
            eNode.next = tail;
            tail.previous.next = eNode;
            eNode.previous = tail.previous;
            tail.previous = eNode;
            current++;
        }
        else{
            head.next.setData(arr);
        }
    }
    public int genelSizeArray(){
        int size = 0;
        int control = 0;
        LinkedArrayListIterator iterator = new LinkedArrayListIterator(head);
        while(control != current){
            size = size + iterator.nextNode.getSize();
            control++;
            if(iterator.hasNext())
                iterator.next();
        }
        return size;
    }
    /**
     * Adds reference of to element, inserting it before the item at position index
     * @param index item position
     * @param element adds reference of to element
     */
    @SuppressWarnings("unchecked")
    @Override
    public void add(int index, E element) {
        index--;
        LinkedArrayListIterator iterator = new LinkedArrayListIterator(head);
        if((index > current*iterator.nextNode.getCapacity()) || index < 0){
            System.out.println("INVALID INDEX");
        }
        else{
            boolean controlNode = false;
            int tempCurrentNode = index / 5;
            int tempIndex = index % 5;
            for(int i=0;i<tempCurrentNode;i++){
                if(iterator.hasNext())
                    iterator.next();
                else{
                    controlNode = true;
                    i = tempCurrentNode;
                }
            }
            if(controlNode){
                if(iterator.nextNode.getSize() == iterator.nextNode.getCapacity()){
                    Node<E> eNode = new Node<>();
                    eNode.next = tail;
                    tail.previous.next = eNode;
                    eNode.previous = tail.previous;
                    tail.previous = eNode;
                    current++;
                    iterator.next();
                    iterator.nextNode.data[tempIndex] = element;
                }
                else
                    System.out.println("Node is not full!! TRY AGAIN!!!");
            }
            else{
                if(iterator.nextNode.data[tempIndex] == null){
                    iterator.nextNode.data[tempIndex] = element;
                }else{
                    if((tempIndex == (iterator.nextNode.capacity-1)) || (iterator.nextNode.data[tempIndex+1] == null)){
                        if(tempIndex == (iterator.nextNode.capacity-1)){
                            if(iterator.hasNext()){
                                E tempElement = iterator.nextNode.next.data[0];
                                iterator.nextNode.next.data[0] = iterator.nextNode.data[tempIndex];
                                iterator.nextNode.data[tempIndex] = element;
                                add(index+3,tempElement);
                            }
                        }else{
                            if(iterator.nextNode.data[tempIndex+1] == null){
                                iterator.nextNode.data[tempIndex+1] = iterator.nextNode.data[tempIndex];
                                iterator.nextNode.data[tempIndex] = element;
                            }
                        }
                    }else{
                        E tempElement = iterator.nextNode.data[tempIndex+1];
                        iterator.nextNode.data[tempIndex+1] = iterator.nextNode.data[tempIndex];
                        iterator.nextNode.data[tempIndex] = element;
                        add((index+3),tempElement);
                    }
                }
            }
        }
    }
    /**
     * Adding to element to last position
     * @param element adding
     */
    @Override
    public boolean add(E element){
        int index = 0;
        int control = 0;
        LinkedArrayListIterator iterator = new LinkedArrayListIterator(head);
        while(control != current){
            index = index + iterator.nextNode.getSize();
            control++;
            if(iterator.hasNext())
                iterator.next();
        }
        index++;
        add(index,element);
        return true;
    }
    /**
     * Gets the current size of List
     * @return current size of List
     */
    @Override
    public int size(){
        return current;
    }
    /**
     * Get the data index
     * @param index The data position at index
     * @return The data at index
     * @throw IndexOutOfBoundsException if index is out of range
     */
    @Override
    public E get(int index) {
        index--;
        if(index < 0 && index >= (current*head.next.getCapacity()) )
            throw new IndexOutOfBoundsException();
        E temp = null;
        int temp_index = 0;
        LinkedArrayListIterator iter = new LinkedArrayListIterator(head);
        boolean control = true;
        boolean controlIndex = false;
        while(control){
            if(iter.nextNode.getCapacity() > index){
                controlIndex = true;
                control = false;
                temp_index = index;
            }else{
                index = index - iter.nextNode.getCapacity();
                if(iter.hasNext()){
                    iter.next();
                }else{
                    control = false;
                }
            }
        }
        if(controlIndex){
            temp = iter.nextNode.data[temp_index];
        }
        return temp;
    }
    @Override
    public String toString() {
        return "LinkedArrayList{" +
                "size=" + size +
                ", current=" + current +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
    public void print(){
        LinkedArrayListIterator iterator = new LinkedArrayListIterator(head);
        int control = 0;
        while (control != current){
            for(int i=0;i<iterator.nextNode.getSize();i++)
                System.out.printf("%s ",iterator.nextNode.getData(i));
            System.out.print("\n");
            control++;
            if(iterator.hasNext())
                iterator.next();
        }
    }
}