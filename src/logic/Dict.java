package logic;

public class Dict<K, V> {
    private Object[] keys;
    private Object[] values;
    private int size;
    private int capacity;

    public Dict(){
        this.capacity = 10;
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
        this.size = 0;
    }
    public Dict(int capacity){
        this.capacity = capacity;
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public K getKeyAt(int index) {
        return (K) this.keys[index];
    }

    public V getValueAt(int index) {
        return (V) this.values[index];
    }

    public void put(K key, V value){
        for(int i = 0; i < this.size; i++){
            if(this.keys[i].equals(key)){
                this.values[i] = value;
                return;
            }
        }
        if(this.size >= this.capacity){
            grow();
        }
        this.keys[this.size] = key;
        this.values[this.size] = value;
        this.size++;
    }
    public void grow(){
        this.capacity *= 2;
        Object[] newKeys = new Object[this.capacity];
        Object[] newValues = new Object[this.capacity];
        for(int i=0; i<this.size; i++){
            newKeys[i] = this.keys[i];
            newValues[i] = this.values[i];
        }
        this.keys = newKeys;
        this.values = newValues;
    }
    public V get(K key){
        for (int i = 0; i<this.size; i++){
            if(this.keys[i].equals(key)){
                return (V) this.values[i];
            }
        }
        return null;
    }
}
