class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<m;i++){
            if(nums1[i] > nums2[0]){
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
            }
            // now sort nums2 array
            Arrays.sort(nums2);
        }
        for(int i=m;i<nums1.length;i++){
            nums1[i] = nums2[i-m];
        }
    }
}