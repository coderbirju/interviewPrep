class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
			return new int[0];
		}
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque();
        int end = 0, i = 0;
        for(end = 0;end < n;end++){
            while(!dq.isEmpty() && dq.peek() < end-k+1)
                dq.poll();
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[end]){
                dq.pollLast();
            }
            dq.offer(end);
            if(end >= k - 1){
                ans[i++] = nums[dq.peek()];
            }
        }
        
        return ans;
   
    }
}