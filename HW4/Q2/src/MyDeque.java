import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDeque<E>  extends AbstractCollection<E> implements Deque<E> {
    private Node<E> front;
    private Node<E> rear;
    private Node<E> removed;
    private int sizeRemoved;
    private int sizeDeque;
    public MyDeque(){
        //front = new Node<>();
       // rear = new Node<>();
        //removed = new Node<>();
        front = null;
        rear = null;
        removed = null;
        sizeRemoved = 0;
        sizeDeque = 0;
    }
    public MyDeque(E data){
        front = new Node<>();
        rear = new Node<>(data);
        removed = new Node<>();
        removed = null;
        sizeRemoved = 0;
        sizeDeque = 1;
        front = rear;
    }
    public int getSizeDeque() {
        return sizeDeque;
    }
    public int getSizeRemoved() {
        return sizeRemoved;
    }
    /**
     * Returns an iterator over the elements in this deque in proper sequence.
     * The elements will be returned in order from first (front) to last (rear).
     * @return an iterator over the elements in this deque in proper sequence.
     */
    @Override
    public Iterator<E> iterator() {
        return new IteratorDeque(front);
    }
    /**
     * Returns an iterator over the elements in this deque in reverse sequential order.
     * The elements will be returned in order from last (front) to first (rear).
     * @return an iterator over the elements in this deque in reverse sequence.
     */
    @Override
    public Iterator<E> descendingIterator() {
        MyDeque<E> deque = new MyDeque<>();
        Iter iter = new Iter(front);
        while (iter.hasNext()){
            deque.addFirst(iter.next().data);
        }
        deque.addFirst(iter.node.data);
        return new IteratorDeque(deque.front);
    }
    /**
     * Insert an data at the front of the deque
     * @param data The element to add
     */
    @Override
    public void addFirst(E data) {
        if(sizeRemoved == 0){
            if(front == null){
                rear = new Node<>(data);
                front = rear;
            }
            else{
                Node<E> eNode = new Node<>(data);
                eNode.next = front;
                front = eNode;
            }
            sizeDeque++;
        }else{
            if(front == null){
                rear = new Node<>(data);
                front = rear;
            }else{
                Node<E> eNode = removed;
                removed = removed.next;
                sizeRemoved--;
                eNode.data = data;
                eNode.next = front;
                front = eNode;
            }
            sizeDeque++;
        }
    }
    /**
     * Insert an data at the rear of the deque
     * @param data The element to add
     */
    @Override
    public void addLast(E data) {
        if(sizeRemoved == 0)
            offer(data);
        else{
            Node<E> eNode = new Node<>(data);
            rear.next = eNode;
            rear = rear.next;
            removed = removed.next;
            sizeRemoved--;
            rear.data = data;
        }
    }
    /**
     * Insert an data at the front of the deque
     * @param data The element to add
     * @return true(always successful)
     */
    @Override
    public boolean offerFirst(E data) {
        if(sizeRemoved == 0){
            if(front == null){
                rear = new Node<>(data);
                front = rear;
            }
            else{
                Node<E> eNode = new Node<>(data);
                eNode.next = front;
                front = eNode;
            }
            sizeDeque++;
        }else{
            if(front == null){
                rear = new Node<>(data);
                front = rear;
            }else{
                Node<E> eNode = removed;
                removed = removed.next;
                sizeRemoved--;
                eNode.data = data;
                eNode.next = front;
                front = eNode;
            }
            sizeDeque++;
        }
        return true;
    }
    /**
     * Insert an data at the rear of the deque
     * @param data The element to add
     * @return true(always successful)
     */
    @Override
    public boolean offerLast(E data) {
        if(sizeRemoved == 0)
            return offer(data);
        else{
            Node<E> eNode = new Node<>(data);
            rear.next = eNode;
            rear = rear.next;
            removed = removed.next;
            sizeRemoved--;
            rear.data = data;
            return true;
        }
    }
    /**
     * Remove the entry at the front of the deque and return it
     * if the deque is not empty
     * @return The data removed if successful
     * @throws NoSuchElementException if deque is empty
     */
    @Override
    public E removeFirst() {
        E dataRemoved =  remove();
        if(sizeRemoved == 0){
            removed = new Node<>(dataRemoved);
        }
        else{
            Node<E> removedNew = new Node<>(dataRemoved);
            removedNew.next = removed;
            removed = removedNew;
        }
        sizeRemoved++;
        return dataRemoved;
    }
    /**
     * Remove the entry at the rare of the deque and return it
     * if the deque is not empty
     * @return The data removed if successful
     * @throws NoSuchElementException if deque is empty
     */
    @Override
    public E removeLast() {
        E removeData;
        if(sizeDeque == 0)
            removeData = null;
        else
            removeData = rear.data;
        if(removeData == null)
            throw new NoSuchElementException();
        Iter myIter = new Iter(front);
        Node<E> eNode = new Node<>();
        while(myIter.hasNext()){
            if(myIter.hasNext()){
                eNode = myIter.next();
            }
        }
        if(sizeRemoved == 0){
            removed = new Node<>(myIter.node.data);

        }
        else{
            Node<E> removedNew = new Node<>(myIter.node.data);
            removedNew.next = removed;
            removed = removedNew;
        }
        sizeRemoved++;
        eNode.next = null;
        rear = eNode;
        sizeDeque--;
        return removeData;
    }
    /**
     * Remove the entry at the front of the deque and return it
     * if the deque is not empty
     * @return The data removed if successful, or null if not
     */
    @Override
    public E pollFirst() {
        E dataRemoved =  poll();
        if(sizeRemoved == 0){
            removed = new Node<>(dataRemoved);
        }
        else{
            Node<E> removedNew = new Node<>(dataRemoved);
            removedNew.next = removed;
            removed = removedNew;
        }
        sizeRemoved++;
        return dataRemoved;
    }
    /**
     * Remove the entry at the rear of the deque and return it
     * if the deque is not empty
     * @return The data removed if successful, or null if not
     */
    @Override
    public E pollLast() {
        E removeData;
        if(sizeDeque == 0)
            removeData = null;
        else
            removeData = rear.data;
        if(removeData == null)
            return null;
        Iter myIter = new Iter(front);
        Node<E> eNode = new Node<>();
        while(myIter.hasNext()){
            if(myIter.hasNext()){
                eNode = myIter.next();
            }
        }
        if(sizeRemoved == 0){
            removed = new Node<>(myIter.node.data);

        }
        else{
            Node<E> removedNew = new Node<>(myIter.node.data);
            removedNew.next = removed;
            removed = removedNew;
        }
        sizeRemoved++;
        eNode.next = null;
        rear = eNode;
        sizeDeque--;
        return removeData;    }
    /**
     * Return the data at front of the deque without removing it.
     * @return The data at front of the deque if successful.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E getFirst() {
        return element();
    }
    /**
     * Return the data at rear of the deque without removing it.
     * @return The data at rear of the deque if successful.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E getLast() {
        if(sizeDeque == 0)
            throw new NoSuchElementException();
        return rear.data;
    }
    /**
     * Return the data at front of the deque without removing it.
     * @return The data at front of the deque if successful,
     * return null if the deque is empty.
     */
    @Override
    public E peekFirst() {
        return peek();
    }
    /**
     * Return the data at rear of the deque without removing it.
     * @return The data at rear of the deque if successful,
     * return null if the deque is empty.
     */
    @Override
    public E peekLast() {
        if(sizeDeque == 0)
            return null;
        else
            return rear.data;
    }
    /**
     * Removes the first occurrence of item in the deque.
     * @param o the first element e such that (o.equals(e))
     * @return true if the item was removed.
     */
    @Override
    public boolean removeFirstOccurrence(Object o) {
        int controlIndex = occurrence(o);
        boolean control = false;
        E data_ = null;
        if(controlIndex == -1)
            control =  false;
        else{
            Iter iter = new Iter(front);
            while(iter.hasNext()){
                Node<E> node = new Node<>();
                node = iter.next();
                controlIndex--;
                if(controlIndex == 0){
                    data_ = iter.node.data;
                    iter.lastNodeReturned.next = iter.node.next;
                    iter.node = iter.node.next;
                    control = true;
                    break;
                }
            }
        }
        if(control){
            Node<E> eNode = new Node<>(data_);
            eNode.next = removed;
            removed = eNode;
            sizeRemoved++;
        }
        return control;
    }
    /**
     * Removes the last occurrence of item in the deque.
     * @param o the last element e such that (o.equals(e))
     * @return true if the item was removed.
     */
    @Override
    public boolean removeLastOccurrence(Object o){
        int controlIndex = occurrence(o);
        boolean control = false;
        E data_ = null;
        if(controlIndex == -1)
            control =  false;
        else{
            Iter iter = new Iter(front);
            while(iter.hasNext()){
                Node<E> node = new Node<>();
                node = iter.next();
                controlIndex--;
                if(controlIndex == 0){
                    data_ = iter.node.data;
                    iter.lastNodeReturned.next = iter.node.next;
                    iter.node = iter.node.next;
                    control = true;
                    break;
                }
            }
        }
        if(control){
            Node<E> eNode = new Node<>(data_);
            eNode.next = removed;
            removed = eNode;
            sizeRemoved++;
        }
        return control;
    }
    public int occurrence(Object o){
        int index = -1;
        boolean control = false;
        Iter iter = new Iter(front);
        while (iter.hasNext()){
            Node<E> node = new Node<>();
            node = iter.next();
            index++;
            if(o.equals(node.data)) {
                control = true;
                break;
            }
        }
        if(!control){
            if(o.equals(iter.node.data))
                index++;
            else
                index = -1;
        }
        return index;
    }
    /**
     * Insert an data at the rear of the deque
     * @param data The element to add
     * @return true(always successful)
     */
    @Override
    public boolean offer(E data) {
        if(front == null){
            rear = new Node<>(data);
            front = rear;
        }
        else{
            rear.next = new Node<>(data);
            rear = rear.next;
        }
        sizeDeque++;
        return true;
    }
    /**
     * Remove the entry at the front of the deque and return it
     * if the deque is not empty
     * @return The data removed if successful
     * @throws NoSuchElementException if deque is empty
     */
    @Override
    public E remove() {
        E controlData = peek();
        if(controlData == null)
            throw new NoSuchElementException();
        front = front.next;
        sizeDeque--;
        return controlData;
    }
    /**
     * Remove the entry at the front of the deque and return it
     * if the deque is not empty
     * @return The data removed if successful, or null if not
     */
    @Override
    public E poll() {
        E controlData = peek();
        if(controlData == null)
            return null;
        front = front.next;
        sizeDeque--;
        return controlData;
    }
    /**
     * Return the data at front of the deque without removing it.
     * @return The data at front of the deque if successful.
     * @throws NoSuchElementException if the deque is empty.
     */
    @Override
    public E element() {
        if(sizeDeque == 0)
            throw new NoSuchElementException();
        return front.data;
    }
    /**
     * Return the data at front of the deque without removing it.
     * @return The data at front of the deque if successful,
     * return null if the deque is empty.
     */
    @Override
    public E peek() {
        if(sizeDeque == 0)
            return null;
        else
            return front.data;
    }
    @Override
    public void push(E e) {
        offer(e);
    }
    @Override
    public E pop() {
        return remove();
    }
    /**
     * Return the size deque
     * @return size
     */
    @Override
    public int size() {
        return sizeDeque;
    }
    public void print(){
        Iter myIter = new Iter(front);
        System.out.println("** My Deque **");
        if(sizeDeque == 1){
            System.out.print(" " + front.data);
        }
        else{
            if(sizeDeque != 0){
                while(myIter.hasNext()){
                    System.out.print(" " + myIter.node.data);
                    if(myIter.hasNext())
                        myIter.next();
                }
                System.out.print(" " + myIter.node.data);
                System.out.println("\n");
            }
        }
        System.out.println("\n** My Removed **");
        Iter myIter2 = new Iter(removed);
        if(sizeRemoved == 1){
            System.out.print(" " + removed.data);
        }
        else{
            if(sizeRemoved != 0){
                while(myIter2.hasNext()){
                    System.out.print(" " + myIter2.node.data);
                    if(myIter2.hasNext())
                        myIter2.next();
                }
                System.out.print(" " + myIter2.node.data);
                System.out.println("\n");
            }
        }
        System.out.println("\n");
    }
    /**
     * A Node is the building block for a single-linked list.
     * @param <E> for generic
     */
    private static class Node<E> {
        private Node<E> next;
        E data;
        public Node(){
            next = null;
            data = null;
        }
        /**
         * Creates a new node with a null next field.
         * @param data_ The data stored.
         */
        public Node(E data_){
            next = null;
            data = data_;
        }
        /**
         * Creates a new node that references another node
         * @param data_ The data stored
         * @param eNode The node referenced by new node
         */
        public Node(E data_, Node<E> eNode){
            data = data_;
            next = eNode;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public void setData(E data) {
            this.data = data;
        }
        public Node<E> getNext() {
            return next;
        }
        public E getData() {
            return data;
        }
    }
    /**
     * Inner class to implement the Iterator<Node<E>> interface
     */
    private class Iter implements Iterator<Node<E>>{
        Node<E> node;
        Node<E> lastNodeReturned;
        int index;
        public Iter(Node<E> eNode){
            node = new Node<>();
            lastNodeReturned = new Node<>();
            node = eNode;
            lastNodeReturned = null;
            index = 0;
        }
        /**
         * If there are more Nodes in the deque to access
         * @return true
         */
        @Override
        public boolean hasNext() {
            return node.next != null;
        }
        /**
         * Returns the next Node in the deque
         * @return The node with subscript index
         */
        @Override
        public Node<E> next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastNodeReturned = node;
            node = node.next;
            index++;
            return lastNodeReturned;
        }
    }
    /**
     * Inner class to implement the Iterator<E> interface
     */
    private class IteratorDeque implements Iterator<E>{
        Node<E> node;
        Node<E> lastNodeReturned;
        int index;
        public IteratorDeque(Node<E> eNode){
            node = new Node<>();
            lastNodeReturned = new Node<>();
            node = eNode;
            lastNodeReturned = null;
            index = 0;
        }
        /**
         * If there are more Nodes in the deque to access
         * @return true
         */
        @Override
        public boolean hasNext() {
            return node.next != null;
        }
        /**
         * Returns the next Node in the deque
         * @return The node with subscript index
         */
        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            lastNodeReturned = node;
            node = node.next;
            index++;
            return lastNodeReturned.data;
        }
    }
}