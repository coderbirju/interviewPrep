class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, (a,b)->{
            double r1 = (double)(a.value) / (double)(a.weight); 
            double r2 = (double)(b.value) / (double)(b.weight); 
            if(r1 < r2) return 1; 
            else if(r1 > r2) return -1; 
            else return 0; 
        });
        
        // Your code here
        /*
            sort based oh highest values/weight ratio, take the max possible amount from each 
            of them
        */
        int availWeight = W;
        double totalValue = 0.0;
        // while(availWeight >= 0){
            
        // }
        for(int i=0;i<n;i++){
            if(availWeight - arr[i].weight >= 0){
                totalValue += arr[i].value;
                availWeight -= arr[i].weight;
            }
            else if(availWeight > 0 && availWeight - arr[i].weight < 0){
                double adjustedValue = ((double)arr[i].value/(double)arr[i].weight) * (double)availWeight;
                totalValue += adjustedValue;
                availWeight = 0;
            }
        }
        
        return totalValue;
        
    }
}