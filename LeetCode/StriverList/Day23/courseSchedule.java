class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
            We need to find the topological ordering of this graph, if there is a toplogical order,
            i.e, a sequence of steps to arrange each vertex, it means that all courses can be taken
            if there is no topological order then there is a loop and it is impossible to finish the course.
        */       
        
        int[] indegrees = new int[numCourses]; // to keep a track of number of pre requisites of each course
        for(int i=0;i<prerequisites.length;i++){
            indegrees[prerequisites[i][0]]++; // if course '0' has course 1 and 3 as pre requisites then indegree[0] = 2
        }
        Queue<Integer> q = new LinkedList(); // to keep track of the courses which have zero requirements currently
        for(int i=0;i<numCourses; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }
        
        if(q.isEmpty())
            return false; // there is not a single course with zero requirements
        
        int count = 0;
        int[] topologicalSortedList = new int[numCourses]; // final list of elements in a sorted arrangement
        
        while(!q.isEmpty()){
            int course = q.poll();
            topologicalSortedList[count] = course;
            count++;
            for(int[] pre : prerequisites)
            {
                if(pre[1] == course){
                    indegrees[pre[0]]--;
                    if(indegrees[pre[0]] == 0){
                        q.add(pre[0]);
                    }
                }
            }
        }
        
        if(count != numCourses) // make sure that all the courses are in the final sorted list, if not then there is a cycle
            return false;
        
        return true;
        
    }
}