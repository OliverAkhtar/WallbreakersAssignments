class MyHashMap {
    
    ListNode[] nodes;
    
    class ListNode {
        int key;
        int value;
        ListNode next;
        
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = index(key);
        ListNode n = find(i, key);
        
        if(n.next == null)
            n.next = new ListNode(key, value);
        else
            n.next.value = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = index(key);
        ListNode n = find(i, key);
        
        return n.next == null ? - 1 : n.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(key);
        ListNode n = find(i, key);
        
        if(n.next == null)
            return;
        else
            n.next = n.next.next;
    }
    
    private int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    
    private ListNode find(int index, int key){
        if(nodes[index] == null)
            nodes[index] = new ListNode(-1, -1);
        
        ListNode n = nodes[index];
        
        while(n.next != null && n.next.key != key)
            n = n.next;
        
        return n;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */