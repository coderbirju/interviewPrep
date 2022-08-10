class Meeting {
    int start;
    int end;
    int position;
    public Meeting(int start, int end, int position){
        this.start = start;
        this.end = end;
        this.position = position;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Meeting> meetings = new ArrayList();
        for(int i=0;i<n;i++){
            Meeting newMeeting = new Meeting(start[i],end[i],i);
            meetings.add(newMeeting);
        }
        Collections.sort(meetings,(Meeting a, Meeting b) -> {
            if(a.end < b.end){
                return -1;
            }else if(a.end > b.end){
                return 1;
            }else if(a.position < b.position){
                return -1;
            }
            return 1;
        });
        
        int count = 1;
        int limit = meetings.get(0).end;
        for(int i=0;i<n;i++){
            Meeting curMeeting = meetings.get(i);
            if(curMeeting.start > limit){
                count++;
                limit = curMeeting.end;
            }
        }
        
        return count;
        
    }
}