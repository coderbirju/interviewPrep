class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList();
        for(int i=0;i<numRows;i++){
            List<Integer> ithList = new ArrayList(i+1);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    ithList.add(j,1);
                else
                    ithList.add(prev.get(j-1) + prev.get(j));
            }
            prev = ithList;
            res.add(ithList);
        }
        return res;
    }
}