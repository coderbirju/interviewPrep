/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID. 

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],    
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3) [resource_3 is accessed at 53760, 54001, and 54060]
most_requested_resource(logs2) # => ('resource_3', 4) [resource_3 is accessed at 1199, 1200, 1201, and 1202]
most_requested_resource(logs3) # => ('resource_5', 1) [resource_5 is accessed at 300]

Complexity analysis variables:

n: number of logs in the input
*/

import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] argv) {
      String[][] logs1 = new String[][] {
        { "58523", "user_1", "resource_1" },
        { "62314", "user_2", "resource_2" },
        { "54001", "user_1", "resource_3" },
        { "200", "user_6", "resource_5" },
        { "215", "user_6", "resource_4" },
        { "54060", "user_2", "resource_3" },
        { "53760", "user_3", "resource_3" },
        { "58522", "user_22", "resource_1" },
        { "53651", "user_5", "resource_3" },
        { "2", "user_6", "resource_1" },
        { "100", "user_6", "resource_6" },
        { "400", "user_7", "resource_2" },
        { "100", "user_8", "resource_6" },
        { "54359", "user_1", "resource_3"},
    };

    String[][] logs2 = new String[][] {
        {"300", "user_1", "resource_3"},
        {"599", "user_1", "resource_3"},
        {"900", "user_1", "resource_3"},
        {"1199", "user_1", "resource_3"},
        {"1200", "user_1", "resource_3"},
        {"1201", "user_1", "resource_3"},
        {"1202", "user_1", "resource_3"}
    };

    String[][] logs3 = new String[][] {
        {"300", "user_10", "resource_5"}
    };
    
    // HashMap<String, int[]> sol = solution(logs3);
    // for(String key : sol.keySet()){
    //   int[] times  = sol.get(key);
    //   System.out.println(key + " " +times[0] + " " + times[1]);
    // }
    
    String[] example = returnResouce(logs2);
    System.out.println(example[0] + " " + example[1]);
    
  }
  
  // private static HashMap<String,int[]> solution(String[][] logs){
  //   HashMap<String,int[]> map = new HashMap();
  //   // int n = logs.length;
  //   for(String[] log : logs){
      
  //     if(map.containsKey(log[1])){
  //       int[] prevTimes = map.get(log[1]);
  //       if(prevTimes[0] > Integer.parseInt(log[0]) ){ // not the oldest
  //         prevTimes[0] = Integer.parseInt(log[0]);
  //       } else if( prevTimes[1] < Integer.parseInt(log[0])){ // not the latest
  //         prevTimes[1] = Integer.parseInt(log[0]);
  //       }
  //       map.put(log[1], prevTimes);
  //     } else{
  //       int[] curTimes = new int[2];
  //       curTimes[0] = Integer.parseInt(log[0]);
  //       curTimes[1] = Integer.parseInt(log[0]);
  //       map.put(log[1], curTimes);
  //     }
  //   }
    
  //   return map;
    
  // }
  
  private static String[] returnResouce(String[][] logs){
    HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    String[] ans = new String[2];
    for(String[] log : logs){
      if(map.containsKey(log[2])){
        ArrayList<Integer> oldTimes = map.get(log[2]);
        oldTimes.add(Integer.parseInt(log[0]));
        map.put(log[2], oldTimes);
      }
      else{
        ArrayList<Integer> times = new ArrayList<Integer>();
        times.add(Integer.parseInt(log[0]));
        map.put(log[2], times);
      }
    }
      
      int maxCount = -1;
      
      for(String key : map.keySet()){
        ArrayList<Integer> times = map.get(key);
        Collections.sort(times);
        for(int i=0;i<times.size() - 1;i++){ 
          int count = 1;
          int curTime = times.get(i);
          int j = i+1;
          
          while(times.get(j) - curTime <= 301 && j<times.size()-1){
            // System.out.println(i  + " "+  j + " " + curTime);
            count++;
            if(count > maxCount){
              maxCount = count;
              ans[0] = key;
              ans[1] = String.valueOf(count); // need to check
            }
            j++;
          }
        }
      }
    return ans;
  }
  
}
