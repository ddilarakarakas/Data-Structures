import java.util.LinkedList;

public class HashTableChain<K,V> implements KWHashMap<K,V> {
    private LinkedList<Entry<K,V>> [] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private static final double LOAD_THRESHOLD = 3.0;
    public HashTableChain(){
        table = new LinkedList[CAPACITY];
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
        for(Entry<K,V> nextItem : table[index])
            if(nextItem.key.equals(key))
                return nextItem.value;
        return null;
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
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            table[index] = new LinkedList<Entry<K,V>>();
        for(Entry<K,V> nextItem : table[index]){
            if(nextItem.key.equals(key)){
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }
        table[index].addFirst(new Entry<K,V>(key,value));
        numKeys++;
        if(numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }
    /**
     * Expands table size when loadFactor exceeds LOAD_THRESHOLD
     * post: The size of the table is doubled ans is an odd integer.
     * The value of numKeys is reset to the number of items
     * actually inserted.
     */
    private void rehash(){
        LinkedList<Entry<K,V>> [] oldTable = table;
        table = new LinkedList[2 * oldTable.length + 1];
        numKeys = 0;
        for(int i=0;i<oldTable.length;i++){
            if(table[i] != null){
                for(Entry<K,V> kvEntry : table[i]){
                    if (kvEntry != null)
                        put(kvEntry.key, kvEntry.value);
                }
            }
        }
    }
    @Override
    public V remove(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;
        if(table[index] == null)
            return null;
        for(Entry<K,V> nextItem : table[index])
            if(nextItem.key.equals(key)) {
                Entry<K,V> remove = nextItem;
                table[index].remove(nextItem);
                return remove.value;
            }
        return null;
    }
    public void print(){
        for(int i=0;i<table.length;i++){
            if(table[i] != null){
                for(Entry<K,V> kvEntry : table[i]){
                    System.out.print("* key : " + kvEntry.key + " value : " + kvEntry.value);
                }
                System.out.print("\n");
            }
        }
    }
    @Override
    public int size() {
        return table.length;
    }
    /**
     * Contains key-value pairs for a hash table
     */
    private static class Entry<K,V>{
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
    }
}
