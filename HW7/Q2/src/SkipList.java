import java.util.Arrays;
/**
 * Implementation of a Skip-List data structure
 * @author Dilara Karakas
 *
 *@param <E> The type of data stored. Must be a Comparable
 */
public class SkipList<E extends Comparable<E>> {
    public SLNode<E> head;
    public SLNode<E> tail;
    private int size;
    private int height;
    public SkipList(){
        head = new SLNode<E>();
        tail = new SLNode<E>();
        head.right = tail;
        tail.left = head;
        SLNode<E> newNode  = new SLNode<>();
        SLNode<E> newNode1  = new SLNode<>();
        SLNode<E> newNode2 = new SLNode<>();
        SLNode<E> newNode3 = new SLNode<>();
        SLNode<E> TnewNode  = new SLNode<>();
        SLNode<E> TnewNode1  = new SLNode<>();
        SLNode<E> TnewNode2  = new SLNode<>();
        SLNode<E> TnewNode3 = new SLNode<>();
        head.up = newNode;
        newNode.up = newNode1;
        newNode1.up = newNode2;
        newNode2.up = newNode3;
        newNode3.down = newNode2;
        newNode2.down = newNode1;
        newNode1.down = newNode;
        newNode.down = head;
        tail.up = TnewNode;
        newNode.up = TnewNode1;
        TnewNode1.up = TnewNode2;
        TnewNode2.up = TnewNode3;
        TnewNode3.down = TnewNode2;
        TnewNode2.down = TnewNode1;
        TnewNode1.down = TnewNode;
        TnewNode.down = tail;
        newNode.right = TnewNode;
        TnewNode.left = newNode;
        newNode1.right = TnewNode1;
        TnewNode1.left = newNode1;
        newNode2.right = TnewNode2;
        TnewNode2.left = newNode2;
        newNode3.right = TnewNode3;
        TnewNode3.left = newNode3;
        size = 0;
        height = 1;

    }
    /**
     * Search for an item in the list
     * @param target The item being sought
     * @return An SLNode which references the predecessors of the target at each level.
     */
    private SLNode<E> search(E target,SLNode<E> root){
        if(root != null){
            if(root.right.sizeData != 0){
                int index = -1;
                E []dataTemp = root.right.data;
                for(int i=0;i<root.sizeData;i++){
                    if(dataTemp[i] != null){
                        if(dataTemp[i].compareTo(target) > 0) {
                            index = i;
                            break;
                        }
                        else if(dataTemp[i].compareTo(target) == 0){
                            return root.right;
                        }
                    }
                }
                if(index == -1){
                    return search(target,root.right);
                }
                else if(index == 0){
                    return search(target,root.down);
                }
                else if(index == 1 || index == 2){
                    return root.right;
                }
            }
        }
        return root;
    }

    /**
     * Find an object in the skip-list
     * @param target The item being sought
     * @return A reference to the object in the skip-list that matches
     * 		   the target. If not found, null is returned
     */
    public E find(E target){
        SLNode<E> pred = search(target,head);
        boolean control = false;
        if(pred != null) {
            for (int k = 0; k < pred.sizeData; k++) {
                if (pred.data[k].compareTo(target) == 0) {
                    control = true;
                    break;
                }
            }
        }
        if(control)
            return target;
        else
            return null;
    }

    /**
     * Inserts the given item
     * @param item The item to add
     * @return true as the item is added
     */
    @SuppressWarnings("unchecked")
    public boolean add(E item){
        size++;
        SLNode<E> temp = head;
        SLNode<E> pred = search(item,temp);
        if(pred != null){
            if(pred.sizeData == 0){
                if(pred.right.sizeData != 0){
                    SLNode<E> newNode = new SLNode<>(item);
                    newNode.right = pred;
                    newNode.left = pred.left;
                    pred.left.right = newNode;
                    pred.left = newNode;
                    size++;
                    newNode.height = logRandom();
                    connection(newNode,pred,newNode.height-1);
                }
                else{
                    SLNode<E> newNode = new SLNode<>(item);
                    newNode.right = tail;
                    newNode.left = head;
                    head.right = newNode;
                    tail.left = newNode;
                    size++;
                    newNode.height = 1;
                    //connection(newNode,pred,newNode.height-1);
                }
            }
            else{
                if(pred.sizeData < 3){
                    int k =0;
                    E [] data_ = (E[]) new Integer[3];
                    E data2 = null;
                    for(int i=0;i<pred.data.length;i++){
                        E tempData = pred.data[i];
                        if(tempData != null){
                            if(tempData.compareTo(item) == 0)
                                return true;
                            else if(tempData.compareTo(item) < 0)
                                data_[k] = pred.data[i];
                            else{
                                data_[k] = item;
                                data2 = pred.data[i];
                            }
                            k++;
                        }
                        else{
                            if(data2 != null){
                                data_[k] = data2;
                                break;
                            }
                            else{
                                data_[k] = item;
                                break;
                            }
                        }
                    }
                    pred.data = data_;
                    pred.sizeData++;
                }
                else if(pred.sizeData == 3){
                    int index = -1;
                    for(int i=0;i<pred.sizeData;i++){
                        E tempData = pred.data[i];
                        if(tempData.compareTo(item) > 0){
                            index = i;
                            break;
                        }
                    }
                    if(index == 1){
                        SLNode<E> newNode = new SLNode<>(pred.data[index+1]);
                        newNode.height = logRandom();
                        pred.data[index+1] = pred.data[index];
                        pred.data[index] = item;
                        pred.sizeData = 3;
                        newNode.left = pred;
                        newNode.right = pred.right;
                        pred.right = newNode;
                        pred.right.left = newNode;
                        size++;
                        connection(newNode,pred.right,newNode.height);
                    }
                    if (index == 2){
                        SLNode<E> TnewNode = new SLNode<>(pred.data[index]);
                        //newNode.sizeData = 1;
                        TnewNode.height = logRandom();
                        pred.data[index] = item;
                        TnewNode.left = pred;
                        TnewNode.right = pred.right;
                        pred.right = TnewNode;
                        pred.right.left = TnewNode;
                        size++;
                        connection(TnewNode,pred.right,TnewNode.height);
                    }
                    if(index == -1){
                        SLNode<E> TnewNode = new SLNode<>(item);
                        TnewNode.left = pred;
                        TnewNode.right = pred.right;
                        pred.right = TnewNode;
                        pred.right.left = TnewNode;
                        size++;
                        TnewNode.height = logRandom();
                        connection(TnewNode,pred,TnewNode.height);
                    }
                }
            }
        }
        return true;
    }
    private void connection(SLNode<E> newNode, SLNode<E> node,int height){
        if(height == 0)
            return;
        else{
            height--;
            SLNode<E> eNode = newNode /*= new SLNode<>()*/;
            // eNode.data = newNode.data;
            eNode.sizeData = newNode.sizeData;
            eNode.height = newNode.height;
            eNode.down = newNode;
            newNode.up = eNode;
            if(node != null)
                node = node.up;
            tail = tail.up;
            head = head.up;
            if(node != null){
                if(node.left != null){
                    eNode.right = node;
                    eNode.left = node.left;
                    node.left.right = eNode;
                    node.left = eNode;
                }
                else {
                    eNode.right = node;
                    eNode.left = head;
                    head.right = eNode;
                    node.left = eNode;
                }
            }
            else{
                if(tail.left != null){
                    eNode.right = tail;
                    eNode.left = tail.left;
                    tail.left.right = eNode;
                    tail.left = eNode;
                }
                else{
                    eNode.right = tail;
                    eNode.left = head;
                    head.right = eNode;
                    tail.left = eNode;
                }
            }
            connection(eNode,node,height);
        }
    }
    /**
     * Removes an instance of the given item
     * @param item The item to remove
     * @return true if the item is removed, false if the item is not in the list
     */
    public boolean remove(E item){
        SLNode<E> pred = search(item,head);
        E control = find(item);
        if(control == null){
            return false;
        } else {
            for (int k = 0; k < pred.sizeData; k++) {
                if(pred.data[k] != null){
                    if (pred.data[k].compareTo(item) == 0) {
                        if(k == 2){
                            pred.data[k] = null;
                            pred.sizeData--;
                            break;
                        }
                        else{
                            if(pred.sizeData == 1){
                                pred.data[0] = null;
                                pred.left.right = pred.right;
                                pred.right.left = pred.left;
                            }
                            if (pred.sizeData - 1 - k >= 0)
                                System.arraycopy(pred.data, k + 1, pred.data, k, pred.sizeData - 1 - k);
                            pred.data[2] = null;
                        }
                    }
                }

            }
            return true;
        }
    }

    /**
     * Method to generate a logarithmic distributed integer between 1 and maxLevel.
     *  I.E. 1/2 of the values are 1, 1/4 are 2, etc.
     * @return a random logarithmic distributed int between 1 and maxLevel
     */
    private int logRandom(){
        return (int) (Math.random() * (0));
    }
    @SuppressWarnings("rawtypes")
    public String toString(){
        if(size == 0)
            return "Empty";
        StringBuilder sc = new StringBuilder();
        SLNode itr = head;
        boolean control = true;
        while(control){
            SLNode temp = itr;
            temp = temp.right;
            while(temp.right != null){
                if(temp.data[0] != null)
                    sc.append(" ***** " + Arrays.toString(temp.data) + " *****");
                temp = temp.right;
            }
            if(itr.down != null) {
                itr = itr.down;
                sc.append("\n");
            }
            else
                control = false;
        }
        return sc.toString();
    }
    /**
     * Static class to contain data and links
     * @author Dilara Karakas
     * @param <E> The type of data stored. Must be a Comparable
     */
    private static class SLNode<E>{
        private E [] data;
        private int sizeData;
        private SLNode<E> right = null;
        private SLNode<E> left = null;
        private SLNode<E> up = null;
        private SLNode<E> down = null;
        private int height;
        /**
         * Create a node null
         */
        @SuppressWarnings("unchecked")
        public SLNode(){
            this.data = (E[]) new Integer[3];
            this.data = null;
            sizeData = 0;
            height = 0;
        }
        /**
         * Create a node
         * @param data_ The data to be stored
         */
        @SuppressWarnings("unchecked")
        public SLNode(E data_){
            this.data = (E[]) new Integer[3];
            this.data[0] = data_;
            sizeData = 1;
            height = 0;
        }
        public String toString(){
            return (Arrays.toString(data));
        }
    }
}