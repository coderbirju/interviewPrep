/*Complete the function below*/
/*
* Cycle detection in DAGs are not straight forward, as there is a direction involved in each edge
    just maintaining a visited array and parent node will not work.
    We should maintain a call stack of each function call to the dfs function, if there is a visit to
    a node in the same call stack then there is a cycle, otherwise we have reached there in a completely 
    different function call, thus it is not a cycle.

    We should also make sure to maintain the active call stack.
 */
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] callStack = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(checkCycleDAG(i, visited, callStack, adj)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkCycleDAG(int node, boolean[] visited,boolean[] callStack, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        callStack[node] = true;
        for(int it: adj.get(node)){
            if(!visited[it]){
                if(checkCycleDAG(it, visited, callStack, adj)){
                    return true;
                }
            } else if(callStack[it]){
                return true;
            }
        }
        callStack[node] = false;
        return false;
    }
    
}