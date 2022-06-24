/*
*
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

1 <= task.length <= 104
tasks[i] is upper-case English letter.
The integer n is in the range [0, 100].
 */


class Solution {
    // Idea: In Every cycle choose the most frequent task first
    // Each cycle size is n+1
    // Most frequent task is fetched in O(1) time by using a Priority Queue(Max Heap)
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> charMap = new HashMap<>(); // Holds the count of each task
        for(char c : tasks){
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder()); 
        // reverse order because by default the PQ is a MinHeap
        
        pq.addAll(charMap.values()); // Add only the values
        int totalTime = 0; // Total time spent to get all the tasks completed
        while(!pq.isEmpty()){
            int timeSpentInCurrentCycle = 0; // time spent in the current cycle in consideration
            List<Integer> tasksChosen = new ArrayList<>(); 
            // tasks chosen in the current cycle in consideration
            for(int i=0;i<n+1;i++){ // current cycle
                if(!pq.isEmpty()){ // as long as there are tasks remaining
                    tasksChosen.add(pq.remove() -1);
                    timeSpentInCurrentCycle++;
                }
            }

            for(int i: tasksChosen){ 
                //if there are any tasks still left after the previous cycle then add it back to PQ
                if(i > 0)
                    pq.add(i);
            }
            // Add up the time spent in this cycle doing tasks
            // if the tasks got completed mid cycle then add only that.. if there were still tasks 
            // left after the cycle then we have used the whole cycle so add the cycle size
            totalTime += pq.isEmpty() ?  timeSpentInCurrentCycle : n+1;
        }
        return totalTime;
    }
}