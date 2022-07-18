public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        int xorr = 0;
        int n = A.size();
        for(int i=0;i<n;i++){
            xorr = xorr ^ A.get(i);
            if(map.get(xorr ^ B) != null){
                count += map.get(xorr^B);
            }
            
            if(xorr == B){
                count++;
            }
            
            if(map.get(xorr) != null){
                map.put(xorr, map.get(xorr) + 1);
            } else {
                map.put(xorr,1);
            }
        }
        return count;
    }