/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> oldToNew = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node != null)
            return dfs(node);
        return null;
        
    }
    
    public Node dfs(Node root){
        if(root == null)
            return root;
        if(oldToNew.containsKey(root.val))
            return root;
        else{
            Node copy = new Node(root.val);
            oldToNew.put(copy.val,copy);
            for(Node n : root.neighbors)
                copy.neighbors.add(dfs(n));
            return copy;
        }
        
    }
}