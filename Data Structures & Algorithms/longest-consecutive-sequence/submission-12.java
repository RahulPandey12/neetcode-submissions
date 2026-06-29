class Solution {
    public int longestConsecutive(int[] nums) {
    HashSet<Integer> hset= new HashSet<>();
    int maxLength=1;
     if(nums.length==0){
      return 0;
     }
      for(int i=0;i<nums.length;i++){
        hset.add(nums[i]);
     }
      for(int num:nums){
        if(!hset.contains(num-1)){
         int current=num;
         int currentLength=1;
         while(hset.contains(current+1)){
            current++;
            currentLength++;
         }
        
        maxLength=Math.max(maxLength,currentLength);
        }
      }
         
       return maxLength;
    }
}
