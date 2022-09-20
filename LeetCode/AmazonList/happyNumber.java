class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        int num = n;
        Set<Integer> foundSums = new HashSet();
        while(sum !=1){
            sum = 0;
            while(num != 0){
                sum += Math.pow(num%10,2);
                num = num/10;
            }
            num = sum;
            if(sum == 1)
                return true;
            if(!foundSums.contains(sum))
                foundSums.add(sum);
            else
                break;
        }
        return false;
    }
}