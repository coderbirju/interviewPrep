/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /* optimal 1 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int n = 0;
        int m = 0;
        while(l1 != null){
            l1 = l1.next;
            n++;
        }
        while(l2 != null){
            l2 = l2.next;
            m++;
        }
        // int i = 0;
        l1 = headA;
        l2 = headB;
        int diff = Math.abs(n-m);
        if(n > m){
            for(int i=0;i<diff;i++){
                l1 = l1.next;
            }
        }
        // i = 0;
        if(m > n){
            for(int i=0;i<diff;i++){
                l2 = l2.next;
            }
        }
        
        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return l1;
        
    }
}

/** optimal 2 */

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        if(a==null){
            a = headB;
        }else{ 
            a = a.next;
        }

        if(b == null){
            b = headA;
        }else{ 
            b = b.next;
        }
        // a = a == null? headB : a.next;
        // b = b == null? headA : b.next;    
    }
    
    return a;
}