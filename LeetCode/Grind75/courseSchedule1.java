/**
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */

/**
 Intuition: 
 Topological sort of a graph
 - build the indegree array for each node
 - push all nodes whose indegres is 0 to a queue (if actual sorting is required use a priority queue)
 - if there are no node with indegree 0 then there's a cycle and topological sort is not possible
 - pop the que elements and check if the popped element is and indegree to any other element, reduce the indegree of
 that element ( effectively saying that you're removing that connection)
 - keep doing this until the queue is empty
 - if there is any node who's indegree is still not 0 at the end of while loop then return false
 - else we found that there is an order which allows us to visit all nodes in the graph and we can complete the course
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegre = new int[numCourses];
        Queue<Integer> nodes = new LinkedList<>();
        for(int[] pre : prerequisites){
            indegre[pre[0]]++;
        }
        for(int i=0; i<indegre.length;i++){
            if(indegre[i] == 0)
                nodes.add(i);
        }
        if(nodes.isEmpty())
            return false;
        while(!nodes.isEmpty()){
            int cur = nodes.poll();
            for(int[] pre: prerequisites){
                if(pre[1] == cur){
                    indegre[pre[0]]--;
                     if(indegre[pre[0]] == 0)
                        nodes.add(pre[0]);
                }   
            }
        }
        for(int i: indegre)
            if(i != 0)
                return false;
                
        return true;
    }
}