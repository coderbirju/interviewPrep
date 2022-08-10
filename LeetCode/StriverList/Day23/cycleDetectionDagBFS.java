/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] indegrees = new int[V];
        int[] sortedTopo = new int[V];
        
        Queue<Integer> q = new LinkedList();
        
        
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                indegrees[it]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        
        if(q.isEmpty())
            return true;
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            sortedTopo[count] = node;
            count++;
            for(int it: adj.get(node)){
                indegrees[it]--;
                if(indegrees[it] == 0)
                    q.add(it);
            }
        }
        if(count == V)
            return false;
        return true;
        
    }
}