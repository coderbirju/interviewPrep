import java.util.*;
class Activity {
    int start;
    int end;
    public Activity(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Solution {
   
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        List<Activity> activities = new ArrayList();
        for(int i=0;i< start.size();i++){
            Activity activity = new Activity(start.get(i), end.get(i));
            activities.add(activity);
        }
        
        Collections.sort(activities, (Activity a, Activity b) -> {
            return a.end - b.end;
        });
        
        int curDeadline = activities.get(0).end;
        int count = 1;
        for(int i=1; i<activities.size();i++){
            if(activities.get(i).start >= curDeadline){
                count++;
                curDeadline = activities.get(i).end;
            }
        }
        return count;
    }
}
