class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        ArrayList<Integer> orderOfVisit = new ArrayList<>();
        int root = 0;
        dfs(root,visited,adj,orderOfVisit);
        return orderOfVisit;
    }
    
    public void dfs(int root, int[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> orderOfVisit){
        if(visited[root] == 0){
            visited[root] = 1;
            orderOfVisit.add(root);
            ArrayList<Integer> neighbors = adj.get(root);
            for(int i=0;i<neighbors.size();i++){
                int node = neighbors.get(i);
                dfs(node, visited, adj,orderOfVisit);
            }
        }
        return;
    }
    
}