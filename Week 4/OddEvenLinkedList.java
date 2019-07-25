/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode n1 = head, n2 = head.next, evenHead = head.next;
        
        while(n2 != null){
            n1.next = n1.next.next;
            n1 = n1.next != null ? n1.next : n1;
            
            n2.next = n2.next != null ? n2.next.next : n2.next;
            n2 = n2.next;
        }
        
        n1.next = evenHead;
        
        return head;
    }
}