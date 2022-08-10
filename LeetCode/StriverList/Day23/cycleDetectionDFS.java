class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(checkCycleDfs(i,-1,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkCycleDfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(int it: adj.get(node)){
            if(!visited[it]){
                if(checkCycleDfs(it,node,adj,visited)){
                    return true;
                }
            } else if(it != parent){
                return true;
            }
        }
        return false;
    }
    
}