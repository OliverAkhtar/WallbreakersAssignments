/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode l1 = null, l2 = head, l3;
        
        while(l2 != null){
            l3 = l2.next;
            l2.next = l1;
            l1 = l2;
            l2 = l3;
        }
        
        return l1;
    }
}