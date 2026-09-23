

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int key,int val) {
        this.key=key;
        this.val=val;
    }
}

class LRUCache {

    HashMap<Integer,ListNode> hmap;
    int capacity;
    ListNode head; //LRU
    ListNode tail;  //MRU

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hmap = new HashMap<>();
        head=null;
        tail=null;
    }

    public int get(int key) {
            if (hmap.containsKey(key)) {
                ListNode node = hmap.get(key);
                removeNode(node);
                add(node);
                return node.val;
            }
        
        return -1;
    }

    public void put(int key, int value) {

             if (hmap.containsKey(key)) {
                ListNode node = hmap.get(key);
                node.val = value;
                removeNode(node);
                add(node);
                return;
            
        }
        ListNode node = new ListNode(key, value);
        // New key and cache is full
        if (hmap.size() == capacity) {
            hmap.remove(head.key);
            removeNode(head);   // Remove LRU
        }

        // New key becomes MRU
        add(node);
        hmap.put(key, node);
        }
    public void add(ListNode node){
        if(head==null){
            head=node;
            tail=node;
            return;
            }
            node.prev=tail;
        tail.next=node;
        tail=node;
    }
    public void removeNode(ListNode node){
      if(node == head){
        head = node.next;
    }

    if(node == tail){
        tail = node.prev;
    }
       if(node.prev!=null){
        node.prev.next=node.next;
       }
       if(node.next!=null){
         node.next.prev=node.prev;
       }
       node.prev=null;
       node.next=null;
    }

    }
