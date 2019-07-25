/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node1 = dummy, node2 = head;
        
        int i = 0;
        while(node2 != null){
            i++;
            if(i % k == 0){
                node1 = reverse(node1, node2.next);
                node2 = node1.next;
            }
            else
                node2 = node2.next;            
        }
        
        return dummy.next;
    }
    
    public ListNode reverse(ListNode start, ListNode end){
        ListNode toReturn = start.next;
        ListNode prev = start.next, curr = start.next.next, next;
        
        while(curr != end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        start.next = prev;
        toReturn.next = end;
        
        return toReturn;
    }
}