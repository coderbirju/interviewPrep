class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	Stack<Node> st = new Stack<>();
	Node cur = root;
	
	while(cur != null){
	    Node temp = cur;
	    cur = cur.next;
	    temp.next = null;
	    st.push(temp);
	    
	}
	
	while(st.size() > 1){
	    Node l1 = st.pop();
	    Node l2 = st.pop();
	    Node l12 = merge(l1,l2);
	    st.push(l12);
	}
	
	return st.pop();
    }
    
    Node merge(Node l1, Node l2){
        Node res = new Node(0);
        Node temp = res;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                temp.bottom = l1;
                l1 = l1.bottom;
            } else {
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp = temp.bottom;
        }
        
        while(l1 != null){
            temp.bottom = l1;
            l1 = l1.bottom;
            temp = temp.bottom;
        }
        
        while(l2 != null){
            temp.bottom = l2;
            l2 = l2.bottom;
            temp = temp.bottom;
        }
        
        return res.bottom;
        
    }
}