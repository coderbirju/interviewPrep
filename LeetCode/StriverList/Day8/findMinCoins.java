import java.util.*;
public class Solution
{
public static int findMinimumCoins(int amount)
    {
        // Write your code here.
    int[] denominations = new int[]{1000, 500, 100, 50, 20, 10, 5, 2, 1};
    int remainAmount = amount;
    List<Integer> coins = new ArrayList<>();
    for(int i=0;i<denominations.length;i++){
        while(remainAmount >= denominations[i]){
            remainAmount -= denominations[i];
            coins.add(denominations[i]);
        }
    }
    return coins.size();
    }
}