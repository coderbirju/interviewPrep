/**
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 

Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104

 */


// OPTIMAL SOLUTION usin Max Heap

/**

II. The second solution is based on the first one. We don't have to sort all points.
Instead, we can maintain a max-heap with size K. Then for each point, we add it to the heap.
Once the size of the heap is greater than K, we are supposed to extract one from the max heap 
to ensure the size of the heap is always K. 

Thus, the max heap is always maintain top K smallest elements from the first one to crruent one. 
Once the size of the heap is over its maximum capacity, it will exclude the maximum element in it, 
since it can not be the proper candidate anymore.

Theoretically, the time complexity is O(NlogK), but pratically, the real time it takes on leetcode 
is 58ms.

The advantage of this solution is it can deal with real-time(online) stream data. 
It does not have to know the size of the data previously.
The disadvatage of this solution is it is not the most efficient solution.(debatable)


 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] left, int[] right){
                return dist(right) - dist(left);
            }
        });
        
        for(int[] point : points){
            pq.add(point);
            if(pq.size() > k)
                pq.poll();
        }
        
        int[][] result = new int[k][2];
        while(k > 0){
            result[--k] = pq.poll();
        }
        return result;
    }
    
    public int dist(int[] point){ // distance from center = (x1^2 + y1^2) - (x2^2 + y2^2)
        return point[0]* point[0] + point[1]*point[1];
    }
}

// OPTIMAL solution using quick select

/**
III. The last solution is based on quick sort, we can also call it quick select. 
In the quick sort, we will always choose a pivot to compare with other elements. 
After one iteration, we will get an array that all elements smaller than the pivot are on the 
left side of the pivot and all elements greater than the pivot are on the right side of the 
pviot (assuming we sort the array in ascending order). 

So, inspired from this, each iteration, we choose a pivot and then find the position p the pivot 
should be. Then we compare p with the K, if the p is smaller than the K, meaning the all element 
on the left of the pivot are all proper candidates but it is not adequate, we have to do the 
same thing on right side, and vice versa. 

If the p is exactly equal to the K, meaning that we've found the K-th position. 
Therefore, we just return the first K elements, since they are not greater than the pivot.

Theoretically, the average time complexity is O(N) , but just like quick sort, in the worst case, 
this solution would be degenerated to O(N^2), and pratically, 
the real time it takes on leetcode is 157ms.

The advantage of this solution is it is very efficient.
The disadvatage of this solution are it is neither an online solution nor a stable one. 
And the K elements closest are not sorted in ascending order.
 */

class Solution {
    public int[][] kClosest(int[][] points, int K) {
    int len =  points.length, l = 0, r = len - 1;
    while (l <= r) {
        int mid = helper(points, l, r);
        if (mid == K) break;
        if (mid < K) {
            l = mid + 1;
        } else {
            r = mid - 1;
        }
    }
    return Arrays.copyOfRange(points, 0, K);
}

private int helper(int[][] A, int l, int r) {
    int[] pivot = A[l];
    while (l < r) {
        while (l < r && compare(A[r], pivot) >= 0) r--;
        A[l] = A[r];
        while (l < r && compare(A[l], pivot) <= 0) l++;
        A[r] = A[l];
    }
    A[l] = pivot;
    return l;
}

private int compare(int[] p1, int[] p2) {
    return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
}
}