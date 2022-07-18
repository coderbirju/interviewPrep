import java.util.* ;
import java.io.*; 
/*
	Following is the structure of the Singly Linked List.	
	class LinkedListNode<T> 
    {
    	T data;
    	LinkedListNode<T> next;
    	public LinkedListNode(T data) 
        {
        	this.data = data;
    	}
	}

*/
public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
        if(head == null || head.next == null)
            return head;
        LinkedListNode<Integer> front = head.next;
        LinkedListNode<Integer> cur = head;
        LinkedListNode<Integer> prev = null;
//         cur.next = null;
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