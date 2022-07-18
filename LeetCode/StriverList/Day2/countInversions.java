import java.util.* ;
import java.io.*; 
public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long[] temp = new long[n];
        long ans = mergeSortEnhanced(arr,temp,0,n-1);
        return ans;
    }
    
    public static long mergeSortEnhanced(long[] arr, long[] temp, int start, int end){
        int mid;
        long invCount = 0;
        if(start < end){
            mid = (start + end)/2;
            
            invCount += mergeSortEnhanced(arr,temp,start,mid);
            invCount += mergeSortEnhanced(arr,temp,mid+1,end);
            
            invCount += merge(arr, temp,start,mid+1,end);
        }
        return invCount;
    }
    
    public static long merge(long[] arr, long[] temp, int start, int mid, int end){
        int i, j,k;
        long invCount = 0;
        i = start;
        j = mid;
        k = start;
        while((i <= mid-1) && (j <= end)){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount = invCount + (mid - i);
            }
        }
        while(i <= mid-1){
            temp[k++] = arr[i++];
        }
        while(j <= end){
            temp[k++] = arr[j++];
        }
        for(i = start ; i <= end ; i++)
            arr[i] = temp[i];
        return invCount;
    }
    
}