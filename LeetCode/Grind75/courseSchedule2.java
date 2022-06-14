/**
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.





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
 - return the order
 */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegre = new int[numCourses];
        int[] finalOrder = new int[numCourses];
        int[] empty = new int[]{};
        Queue<Integer> nodes = new LinkedList<>();
        for(int[] pre : prerequisites){
            indegre[pre[0]]++;
        }
        for(int i=0; i<indegre.length;i++){
            if(indegre[i] == 0)
                nodes.add(i);
        }
        if(nodes.isEmpty()){
            return empty;
        }
        int j = 0;
        while(!nodes.isEmpty()){
            int cur = nodes.poll();
            finalOrder[j++] = cur;
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
                return empty;
                
        return finalOrder;
    }
}