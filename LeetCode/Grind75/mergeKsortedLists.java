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

// Use a minimum priority queue to store k nodes. Pop the smallest node and offer its next node if it is not null
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b) -> Integer.compare(a.val,b.val));
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if(cur.next != null){
                pq.add(cur.next);
            }
        }
        return head.next;
    }
}