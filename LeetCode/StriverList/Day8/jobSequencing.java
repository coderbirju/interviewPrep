class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a,b) -> { return b.profit - a.profit; });
        int profit = 0;
        int count = 0;
        int maxDeadline = 0;
        for(int i=0; i<n; i++){
            if(arr[i].deadline > maxDeadline){
                maxDeadline = arr[i].deadline;
            }
        }
        int[] timeTable = new int[maxDeadline + 1];
        for(int i=1;i<=maxDeadline;i++){
            timeTable[i] = -1;
        }
        
        for(int i=0;i<n;i++){
            // int deadline = arr[i].deadline -1;
            for (int j = arr[i].deadline; j > 0; j--) {

            // Free slot found 
            if (timeTable[j] == -1) {
               timeTable[j] = i;
               count++;
               profit += arr[i].profit;
               break;
            }
         }
            // if(timeTable[deadline] == -1){
            //     timeTable[deadline] = arr[i].id;
            //     count++;
            //     profit += arr[i].profit;
            // } else {
            //     int j = deadline;
            //     while(j>= 0 && timeTable[j] != -1){
            //         j--;
            //     }
            //     if(j<0){
            //         break;
            //     }else{
            //         timeTable[j] = arr[i].id;
            //         count++;
            //         profit += arr[i].profit;
            //     }
            // }
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = profit;
        return ans;
    }
}