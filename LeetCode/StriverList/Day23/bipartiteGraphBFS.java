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
        Queue<Integer> q = new LinkedList();
        q.add(node);
        color[node] = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int it: graph[cur]){
                if(color[it] == -1){
                    color[it] = 1 - color[cur];
                    q.add(it);
                } else if(color[it] == color[cur]){
                    return false;
                }
            }
        }
        return true;
    }
}