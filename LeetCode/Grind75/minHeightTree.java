/*
*
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees,
those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
Return a list of all MHTs' root labels. You can return the answer in any order.
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
Example 1:

Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:

Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]

Constraints:

1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.

*/



/*
    Naive approach
    - dfs on each node and choose the minimum.. but how will you chose the
    minimum when there are more than one MHT?
    
    Optimal Approach
    - fact: the tree is most balanced when the root is in the center of the graph
    - leaf nodes give the worst possible heights(max heights) so eliminate them
    - there can be at most 2 MHTs(as in two center nodes) use this idea
    we eliminate the leaf nodes(nodes with degree 1) and keep doing it till we
    get 2 or less nodes
    - copy all the remaining nodes into the result and return it
*/

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        int[] inDegrees = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        
        
        if(n == 0)
            return result;
        if(n==1){
            result.add(0);
            return result;
        }
            
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            inDegrees[edge[0]]++;
            inDegrees[edge[1]]++;
        }
        int count = n;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegrees[i] == 1){
                q.add(i);
            }
        }
        while(count > 2){
            int size = q.size();
            count -= size;
            while(size-->0){
                int v = q.poll();
                for(int con: adj.get(v)){
                    inDegrees[con]--;
                    if(inDegrees[con] == 1){
                        q.add(con);
                    }
                }
            }
        }
        result.addAll(q);
        return result;
    }
    
}