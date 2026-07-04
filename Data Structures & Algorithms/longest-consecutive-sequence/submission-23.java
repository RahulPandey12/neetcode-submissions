class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length==0){
         return 0;
      }
      HashSet<Integer> hset= new HashSet<>();
      int maxLength=1;
      int currentLen=1;
      int currentNum=0;
      for(int num: nums){
         hset.add(num);
      }
      for(int num: nums){
        if(!hset.contains(num-1)){
          currentNum=num;
          currentLen=1;
           while(hset.contains(currentNum+1)){
               currentLen++;
               currentNum++;
         }
         maxLength=Math.max(currentLen,maxLength);
        }
        
      }
    return maxLength;
    }
}
