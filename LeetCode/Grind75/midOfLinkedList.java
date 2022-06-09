/**
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.



 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public ListNode middleNode(ListNode head) {
        
        // optimal fast slow 1pass
        ListNode fast,slow;
        fast = head;
        slow = head;
        while(fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

        /*
         brute solution 2 pass

        int len = 0;
        ListNode cur = head;
        
        if(head.next == null || head == null)
            return head;
        
        
        while(cur != null){
            cur = cur.next;
            len++;
        }
        
        int mid = len%2 == 0 ? len/2 + (len%2) : len/2 + (len%2) -1;
        // System.out.println(len +" "+mid);
        cur = head;
        
        for(int i=0;i<mid;i++){
            cur = cur.next;
            // mid--;
        }
        
        return cur;
        */
    }
}