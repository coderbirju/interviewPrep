/**
You are given an array of variable pairs equations and an array of real numbers values, 
where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. 
Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
*/


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
	//  adjacency list for each node 
        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();
        for(int i=0;i<values.length;i++){
		// build the list here
            List<String> l = equations.get(i);
            String from = l.get(0);
            String to = l.get(1);
            if(!adj.containsKey(from)){
                adj.put(from,new HashMap());
            }
            if(!adj.containsKey(to)){
                adj.put(to, new HashMap());
            }
            adj.get(from).put(to, values[i]);
            adj.get(to).put(from, 1/values[i]);
        }
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size();i++){
            List<String> curQuery = queries.get(i);
            String from = curQuery.get(0);
            String to = curQuery.get(1);
            res[i] = dfs(from, to,1.0,adj,new HashSet<>());
        }
        return res;
    }
    
    public double dfs(String from, String to, double val, HashMap<String, HashMap<String, Double>> adj, HashSet<String> visited){
	// if the node is not at all present of if we have already visited the node return -1
        if(!adj.containsKey(from) || !visited.add(from))
            return -1;
	// node to itself? return value
        if(from.equals(to))
            return val;
			// fetch all neighbours of from node
        HashMap<String, Double> neighbours = adj.get(from);
        for(String neighbour : neighbours.keySet()){
		// for each neighbour do dfs, update the cost by multiplying the value
            double result = dfs(neighbour, to, val * neighbours.get(neighbour), adj, visited);
            if (result != -1) return result;
        }
        return -1;
    }
}