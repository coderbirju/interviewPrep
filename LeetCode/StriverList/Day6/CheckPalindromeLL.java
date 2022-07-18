/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;
       
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2;
        if(fast != null){
            l2 = reverse(slow.next);
        } else {
            l2 = reverse(slow);
        }
        ListNode l1 = head;
        while(l2 != null){
            if(l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
        
        
    }
    
    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode front = head.next;
        ListNode prev = null;
        while(front != null){
            cur.next = prev;
            prev = cur;
            cur = front;
            front = front.next;
        }
        cur.next = prev;
        return cur;
    }
}