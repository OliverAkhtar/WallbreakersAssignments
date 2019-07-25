class ListNode {

  public int val;
  public int key;
  public ListNode next;
  public ListNode prev;
  public ListNode(int x) {val = x;}
  public ListNode(int key, int val) {
    this.key = key;
    this.val = val;
  }

}

class LRUCache {

  ListNode head;
  ListNode tail;

  Map<Integer, ListNode> map = new HashMap<>();
  private int capacity;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      ListNode node = map.get(key);
      moveNodeToHead(node);
      return head.val;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      ListNode node = map.get(key);
      node.val = value;
      moveNodeToHead(node);
    } else {
      if (map.size() < capacity) {
        if (head == null) {
          head = new ListNode(key, value);
          tail = head;
        } else {
          ListNode node = new ListNode(key, value);

          head.prev = node;
          node.next = head;
          head = node;
          head.prev = null;
        }
        map.put(key, head);
      } else {
        ListNode newHead = new ListNode(key, value);

        head.prev = newHead;
        newHead.next = head;
        head = newHead;
        head.prev = null;

        map.put(key, newHead);

        map.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
      }
    }
  }

  private void moveNodeToHead(ListNode node) {

    if (node != head) {
      if (tail != node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
      } else {
        tail = tail.prev;
        tail.next = null;
      }

      head.prev = node;
      node.next = head;
      head = node;
      head.prev = null;
    }
  }
}