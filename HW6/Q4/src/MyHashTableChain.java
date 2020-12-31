public class MyHashTableChain<K extends Comparable<K>,V>  implements KWHashMap<K,V>{
    private BinarySearchTree<Entry<K,V>>[] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;
    public MyHashTableChain(){
        table = new BinarySearchTree[CAPACITY];
    }
    /**
     * Method get for class HashTableChain.
     * @param key The key being sought
     * @return The value associated with this key if found; otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;
        BinarySearchTree<Entry<K,V>> temp = table[index];
        return getRecursive(temp,key);
    }
    /**
     * Recursive get
     */
    private V getRecursive(BinarySearchTree<Entry<K,V>> o,Object key) {
        K tempK = (K) key;
        if(o.root == null)
            return null;
        int compResult = o.root.data.key.compareTo(tempK);
        if(compResult == 0)
            return o.root.data.value;
        else if(compResult > 0)
            return getRecursive(o.getLeftSubTree(o), key);
        else
            return getRecursive(o.getRightSubTree(o),key);
    }
    @Override
    public boolean isEmpty() {
        return table.length == 0;
    }
    /**
     * Method put for class HashTableChain.
     * post: This key-value pair is inserted in the table and numKeys is incremented.
     * If the key is already in the table, its value is changed to the argument value
     * and numKeys is not changed.
     * @param key The key of item being inserted
     * @param value The value for this key
     * @return The old value associated with this key if found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        V control = null;
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            table[index] = new BinarySearchTree<Entry<K,V>>();
        if(table[index].root != null)
            control = putRecursive(key,value,table[index]);
        if(control == null){
            table[index].add(new Entry<K,V>(key,value));
            numKeys++;
            if(numKeys > (LOAD_THRESHOLD * table.length))
                rehash();
        }
        return control;

    }
    /**
     * Recursive put
     */
    private V putRecursive(K key,V value,BinarySearchTree<Entry<K,V>> o){
        if(o.root != null){
            if(o.root.data.key.compareTo(key) == 0){
                V oldVal = o.root.data.value;
                o.root.data.setValue(value);
                return oldVal;
            }
            else if(o.root.data.key.compareTo(key) < 0)
                return putRecursive(key,value,o.getLeftSubTree(o));
            else if(o.root.data.key.compareTo(key) > 0)
                return putRecursive(key,value,o.getRightSubTree(o));
            else
                return null;
        }
        else
            return null;
    }
    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * post: The size of the table is doubled ans is an odd integer.
     * The value of numKeys is reset to the number of items
     * actually inserted.
     */
    private void rehash(){
        BinarySearchTree<Entry<K,V>> [] oldTable = table;
        table = new BinarySearchTree[2 * oldTable.length + 1];
        numKeys = 0;
        for(int i=0;i<oldTable.length;i++){
            rehashRecursive(oldTable[i]);
        }
    }
    /**
     * Recursive rehash
     */
    private void rehashRecursive(BinarySearchTree<Entry<K,V>> o){
        if(o.root != null) {
            put(o.root.data.key, o.root.data.value);
            rehashRecursive(o.getLeftSubTree(o));
            rehashRecursive(o.getRightSubTree(o));
        }
    }
    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;
        return removeRecursive(table[index],key,index);
    }
    private V removeRecursive(BinarySearchTree<Entry<K,V>> o,Object key,int index) {
        K tempK = (K) key;
        if(o.root == null)
            return null;
        int compResult = o.root.data.key.compareTo(tempK);
        if(compResult == 0) {
            V remove = o.root.data.value;
            table[index].delete(o.root.data);
            return remove;
        }
        else if(compResult > 0)
            return removeRecursive(o.getLeftSubTree(o), key,index);
        else
            return removeRecursive(o.getRightSubTree(o),key,index);
    }
    public void print(){
        for(int i=0;i<table.length;i++){
            if(table[i] != null)
                System.out.println(i + ". index\n" + table[i].toString());
        }
    }
    @Override
    public int size() {
        return table.length;
    }
    /**
     * Contains key-value pairs for a hash table (Comparable)
     */
    private static class Entry<K extends Comparable<K>,V> implements Comparable<Entry<K,V>>{
        private K key;
        private V value;
        /**
         * Creates a new key-value pair.
         * @param key The key
         * @param value The value
         */
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        /**
         * Retrieves the key
         * @return The key
         */
        public K getKey(){
            return key;
        }
        /**
         * Retrieves the value
         * @return The value
         */
        public V getValue() {
            return value;
        }
        /**
         * Sets the value
         * @param val The new value
         * @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            this.value = val;
            return oldVal;
        }
        @Override
        public int compareTo(Entry<K, V> o) {
            return this.key.compareTo(o.key);
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append(" - ");
            sb.append(value);
            return sb.toString();
        }
    }

}
