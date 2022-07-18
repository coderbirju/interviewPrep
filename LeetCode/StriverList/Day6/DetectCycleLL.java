import java.util.* ;
import java.io.*; 
/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class Solution {
    
    public static boolean detectCycle(Node<Integer> head) {
        //Your code goes here
         if (head == null || head.next == null) {
            return false;
        }

        //  Slow Pointer - This will be incremented by 1 Nodes.
        Node<Integer> slow = head;
        //  Fast Pointer  - This will be incremented by 2 Nodes.
        Node<Integer> fast = head.next;
        
        while (slow != fast) {

            //  We reached the end of the List and haven't found any Cycle.
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        //  We found a Cycle.
        return true;
    }
}