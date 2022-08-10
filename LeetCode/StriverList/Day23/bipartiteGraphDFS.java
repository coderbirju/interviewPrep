class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
       
        Arrays.fill(color, -1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                boolean ans = isBipartite(color, graph, i);
                System.out.println("ans " + ans);
                if(!ans){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isBipartite(int[] color, int[][] graph, int node){
        if(color[node] == -1){
            color[node] = 1;
        }
            
        
        for(int it: graph[node]){
            if(color[it] == -1){
                color[it] = 1 - color[node];
                if(!isBipartite(color, graph, it)){
                    return false;
                }
            } 
            else if(color[it] == color[node])
            {
                return false;
            }
        }
        return true;
    }
}