/**
21. Merge Two Sorted Lists
Easy

12279

1124

Add to List

Share
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.











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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        if(cur1 == null && cur2 == null){
            return null;
        }
        
        if(cur1 == null && cur2 != null){
            head = cur2;
            return head;
        }
        if(cur2 == null && cur1 != null){
            head = cur1;
            return head;
        }
        
        if(cur1.val <= cur2.val){
            head = cur1;
            cur1 = cur1.next;
        } else {
            head = cur2;
            cur2 = cur2.next;
        }
        ListNode newCur = head;
        
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                newCur.next = cur1;
                cur1 = cur1.next;
            } else {
                newCur.next = cur2;
                cur2 = cur2.next;
            }
            newCur = newCur.next;
        }
        if(cur1 == null && cur2 != null){
            newCur.next = cur2;
            cur2 = cur2.next;
        }
        if(cur1 != null && cur2 == null){
            newCur.next = cur1;
            cur1 = cur1.next;
        }
        return head;
    }
}