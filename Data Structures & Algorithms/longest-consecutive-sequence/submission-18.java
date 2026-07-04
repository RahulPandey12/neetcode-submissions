class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length==0){
         return 0;
      }
    Arrays.sort(nums);
    int maxLength=1;
    int currentLength=1;
    for(int i=1;i<nums.length;i++){

      if((nums[i]-nums[i-1])==1){
         currentLength++;
      }
      else if(nums[i]==nums[i-1]){
         continue;
      }
      else{
         maxLength=Integer.max(currentLength,maxLength);
         currentLength=1;
      }
    }
    maxLength=Integer.max(currentLength,maxLength);
    return maxLength;
    }
}
