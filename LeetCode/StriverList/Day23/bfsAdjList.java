class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        ArrayList<Integer> orderOfVisit = new ArrayList<Integer>();
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int node = q.poll();
            if(visited[node] == 0){
                visited[node] = 1;
                orderOfVisit.add(node);
                ArrayList<Integer> neighbours = adj.get(node);
                for(int i=0; i<neighbours.size();i++){
                    if(visited[neighbours.get(i)] == 0){
                        q.add(neighbours.get(i));
                    }
                }
            }
        }
        return orderOfVisit;
    }
}