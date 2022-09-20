
int[] bucketSize;

 public int collectingPebbles(int numberOfPebbles, int[] bucketSize){
    int n = bucketSize.length;
    this.bucketSize = new int[n];
    this.bucketSize = bucketSize.clone();
    int[][] dp = new int[numberOfPebbles+1][n];
    for(int[] row: dp){
        Arrays.fill(dp,-1);
    }
    int answer = recursive(n - 1, numberOfPebbles, dp);
    if(answer == Integer.MAX_VALUE)
        return -1;
    return answer;
}

private int recursive(int index, int remainPebels, int[][] dp){
    if (remainPebels < 0)
        return Integer.MAX_VALUE;
    if (index == 0){
        if (remainPebels < bucketSize[0])
            return Integer.MAX_VALUE;
        if (remainPebels % bucketSize[0] == 0){
            double val = remainPebels / bucketSize[0];
            
        }
            return answer = Math.floorDiv(remainPebels, bucketSize[0]);
        return Integer.MAX_VALUE;
    }
        

    if(remainPebels == 0)
        return 0;

    if(dp[index][remainPebels] != -1)
        return dp[index][remainPebels];

    int pick = 1 + recursive(index, remainPebels - bucketSize[index], dp);
    int nopick = recursive(index - 1, remainPebels, dp);

    dp[index][remainPebels] = Math.min(pick, nopick);
    return Math.min(pick, nopick)
}

public static void main(String[] args) {
    System.out.println("Hello, World!");
    int numP = 4;
    int[] bucketSizes = new int[]{2,4};
    System.out.println(collectingPebbles(numP, bucketSizes));
}