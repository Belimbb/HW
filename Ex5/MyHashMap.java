package ForGit.Ex5;

public class MyHashMap<K, V> {
    private Entry<K, V>[] buckets;

    public MyHashMap() {
        this.buckets = new Entry[10];
    }
    public void put(K key, V value){
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> kvEntry = new Entry<>();
        kvEntry.setKey(key);
        kvEntry.setValue(value);

        if (buckets[bucketNumber] == null){
            buckets[bucketNumber] = kvEntry;
        }else {
            Entry<K, V> currentEntry = buckets[bucketNumber];
            while (currentEntry.getNextEntry() != null){
                currentEntry = currentEntry.getNextEntry();
            }
        }
    }
    public void remove(K key){
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;
        Entry<K, V> currentEntry = buckets[bucketNumber];
        Entry<K, V> previousEntry = null;
        while (currentEntry != null) {
            if (currentEntry.getKey().equals(key)) {
                if (previousEntry == null) {
                    buckets[bucketNumber] = currentEntry.getNextEntry();
                } else {
                    previousEntry.setNextEntry(currentEntry.getNextEntry());
                }
                return;
            }

            previousEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();
        }
    }
    public void clear(){
        buckets = new Entry[10];
    }
    public int size() {
        int count = 0;

        for (Entry<K, V> bucket : buckets) {
            Entry<K, V> currentEntry = bucket;

            while (currentEntry != null) {
                count++;
                currentEntry = currentEntry.getNextEntry();
            }
        }

        return count;
    }
    public V get(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;
        Entry<K, V> currentEntry = buckets[bucketNumber];

        while (currentEntry != null) {
            V v = checkEquals(currentEntry, key);
            if (v != null) {
                return v;
            }
            currentEntry = currentEntry.getNextEntry();
        }

        return null;
    }
    private V checkEquals(Entry<K, V> entry, K key){
        if (entry.getKey().equals(key)){
            return entry.getValue();
        }
        return null;
    }
}
