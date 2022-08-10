class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        int i=0;
        ArrayList<Integer> arr2 = new ArrayList();
        recursionSub(i,0,N,arr,arr2);
        return arr2;
    }
    
    void recursionSub(int index, int sum, int n, ArrayList<Integer> arr, ArrayList<Integer> arr2){
        // if index is out of bound
        if(index >= n){
            arr2.add(sum);
            return;
        }
        // choose the current element
        recursionSub(index+1, sum + arr.get(index), n, arr, arr2);
        
        // don't choose the current element
        recursionSub(index+1, sum, n, arr, arr2);
    }
    
}