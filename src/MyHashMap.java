import java.util.Arrays;

public class MyHashMap<K, V> {
    private int capacity;
    private Bucket[] buckets;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Bucket[capacity];
    }

    public void put(K key, V value) {
        Bucket bucket = getBucketByKey(key);
        if(bucket.containsKey(key)) {
            bucket.add(new MyEntry<>(key, value));
        }
        bucket.add(new MyEntry<>(key, value));
    }

    private Bucket getBucketByKey(K key) {
        int keyHash = key.hashCode();
        int bucketIndex = keyHash % capacity;
        return getInitBucket(bucketIndex);
    }

    private Bucket getInitBucket(int index) {
        if(buckets[index] == null) {
            buckets[index] = new Bucket();
        }
        return buckets[index];
    }

    public void remove(K key) {
        Bucket bucket = getBucketByKey(key);
        bucket.remove(key);
    }

    public void clear() {
        this.buckets = new Bucket[capacity];
    }

    public int size() {
        int size = 0;
        for(Bucket bucket : buckets) {
            if(bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }

    public V get(K key) {
        Bucket bucket = getBucketByKey(key);
        if(bucket.containsKey(key)) {
            return (V) bucket.get(key).getValue();
        } else {
            return null;
        }
    }

    public static class Bucket {
        private Node<Object, Object> first;

        public void add(MyEntry<Object, Object> entry) {
            if(first == null) {
                first = new Node<>(entry);
            } else {
                Node<Object, Object> current = first;
                while (current.hasNext()) {
                    current = current.getNext();
                }
                current.setNext(entry);
            }
        }

        public void remove(Object key) {
            if(first == null) {
                return;
            } else {
                Node<Object, Object> current = first;
                if(current.getEntry().getKey().equals(key)) {
                    first = first.getNext();
                    return;
                }
                while (current.hasNext()) {
                    Node<Object, Object> next = current.getNext();
                    MyEntry<Object, Object> nextEntry = next.getEntry();
                    if(nextEntry.getKey().equals(key)) {
                        current.setNext(next.getNext());
                        next.setNextToNull();
                    }
                    current = first.getNext();
                }
            }
        }

        public MyEntry<Object, Object> get(Object key) {
            if(first == null) {
                return null;
            } else {
                Node<Object, Object> current = first;
                while (current.hasNext()) {
                    if(current.getEntry().getKey().equals(key)) {
                        return current.getEntry();
                    }
                    current = current.getNext();
                }
                if(current.getEntry().getKey().equals(key)) {
                    return current.getEntry();
                }
                // not found
                return null;
            }
        }

        public boolean containsKey(Object key) {
            return get(key) != null;
        }

        public int size() {
            if(first == null) {
                return 0;
            } else {
                Node<Object, Object> current = first;
                int size = 1;
                while (current.hasNext()) {
                    size++;
                    current = first.getNext();
                }
                return size;
            }
        }
    }

    public static class Node<K, V> {
        MyEntry<K, V> entry;
        Node<K, V> next;

        Node(MyEntry<K, V> entry) {
            this.entry = entry;
        }

        public void setNext(Node<K, V> node) {
            this.next = node;
        }

        public void setNext(MyEntry<K, V> entry) {
            this.next = new Node(entry);
        }

        public void setNextToNull() {
            this.next = null;
        }

        public void setEntry(MyEntry<K, V> entry) {
            this.entry = entry;
        }

        public MyEntry<K, V> getEntry() {
            return entry;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }

    public static class MyEntry<K, V> {
        private final K key;
        private final V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
            if(key == null) {
                throw new IllegalArgumentException("Key can't be null");
            }
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


}