class Node {
    int key, value;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}


class MyHashMap {
        Node[] hashes;
        private final int mod = 1009;
        private final int size = 10000000;
    
    /*
        List of nodes in the class, size predefined, take a large prime number why?
        Hash function creates a integer hash value based on certain modulo operations
        
        put - calculate the hash key to find the dummy head of the linked list, if list[hashKey]           is null then that means that this is the first time this hash key is being used, so create         a new linked list with a dummy node and add the user given key as the first link
        if it is already present then find the linked list with value as key value and update it
        if linked list is there but there is no node with given key then add it as the new last           node into that list
        
        get - find the hashKey of the given key
        if this index is null then return null
        otherwise search the linked list for the node containing the key as its key return the             data of this node
        
        
        Some of the questions which can be asked to the interviewer before implementing the               solution

        For simplicity, are the keys integers only?
        For collision resolution, can we use chaining?
        Do we have to worry about load factors?
        Can we assume inputs are valid or do we have to validate them?
        Can we assume this fits memory?
    */

    public MyHashMap() {
        hashes = new Node[size];
    }
    
    public void put(int key, int value) {
        int hashKey = hash(key);
        if(hashes[hashKey] == null){
            Node dummyHead = new Node(-1,-1);
            hashes[hashKey] = dummyHead;
            Node newNode = new Node(key,value);
            dummyHead.next = newNode;
        } else {
            Node dummyHead = hashes[hashKey];
            Node cur = dummyHead;
            while(cur.next != null && cur.next.key != key){
                cur = cur.next;
            }
            if(cur.next == null){
                cur.next = new Node(key,value);
            } else {
                if(cur.next.key == key)
                    cur.next.value = value;
            }
        }
    }
    
    private int hash(int key) {
        return key % this.mod;
    }
    
    public int get(int key) {
        int hashKey = hash(key);
        if(hashes[hashKey] == null)
            return -1;
        Node dummyHead = hashes[hashKey];
        Node cur = dummyHead;
        while(cur.next != null && cur.next.key != key){
            cur = cur.next;
        }
        if(cur.next == null)
            return -1;
        return cur.next.value;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        if(hashes[hashKey] == null)
            return;
        Node dummyHead = hashes[hashKey];
        Node cur = dummyHead;
        while(cur.next != null && cur.next.key != key){
            cur = cur.next;
        }
        if(cur.next == null)
            return;
        cur.next = cur.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */