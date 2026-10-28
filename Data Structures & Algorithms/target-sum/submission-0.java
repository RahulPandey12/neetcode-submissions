class Solution {
    public int findTargetSumWays(int[] nums, int target) {
      int sum=0; 
        int n=nums.length;
               for(int i=0;i<n;i++){
                   sum=sum+nums[i];
               }
       int sum1=(sum+target)/2;
       if (Math.abs(target) > sum)
    return 0;
       if((sum + target) % 2 != 0)
         return 0;
       return perfectSum(nums,sum1);
        
    }
    static int t[][];
    static int perfectSum(int[] arr, int target) {
          int n=arr.length;
         t= new int[n+1][target+1];
         //base case
         for(int i=0;i<n+1;i++){
             for(int j=0;j<target+1;j++){
                 if(i==0){
                     t[i][j]=0;
                 }
                 if(j==0){
                     t[i][j]=1;
                 }
             }
         }
         for(int i=1;i<n+1;i++){
             for(int j=0;j<target+1;j++){
                 if(arr[i-1]<=j){
                     t[i][j]= t[i-1][j-arr[i-1]] +
                            t[i-1][j];
                 }
                 else if(arr[i-1]>j){
                      t[i][j]= t[i-1][j];
                 }
                 }
         }
                 return t[n][target];


    }
}