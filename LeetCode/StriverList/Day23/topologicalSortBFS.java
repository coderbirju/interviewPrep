class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
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
            return sortedTopo;
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
        return sortedTopo;
    }
}
