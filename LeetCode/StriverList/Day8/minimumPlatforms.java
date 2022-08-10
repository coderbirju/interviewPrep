class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platformsNeeded = 1;
        int currentOccupiedPlatforms = 1;
        int i=1;
        int j =0;
        while(i<n && j <n){
            if(arr[i] <= dep[j]){
                currentOccupiedPlatforms++;
                i++;
            }
            else if(arr[i] > dep[j]){
                currentOccupiedPlatforms--;
                j++;
            }
            
            platformsNeeded = Math.max(currentOccupiedPlatforms,platformsNeeded);
            
        }
        return platformsNeeded;
    }
    
}