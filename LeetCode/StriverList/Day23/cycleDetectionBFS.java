class Node {
    int ver;
    int par;
    public Node(int ver, int par){
        this.ver = ver;
        this.par = par;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
            if(vis[i]==false) 
                if(checkCycle(adj, i,vis)) 
                    return true;
    
        return false;
    }
    
    private boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited){
       Queue<Node> q = new LinkedList();
       Node root = new Node(start, -1);
       q.add(root);
       visited[start] = true;
       while(!q.isEmpty()){
           Node cur = q.poll();
           for(int neighbor : adj.get(cur.ver)){
              if(!visited[neighbor]){
                  visited[neighbor] = true;
                  Node newNeigh = new Node(neighbor, cur.ver);
                  q.add(newNeigh);
              } else if(neighbor != cur.par) {
                  return true;
              }
           }
       }
       return false;
    }
}