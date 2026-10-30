class Solution {
    public int maxProduct(int[] nums) {
        int prefixProduct=1;
        int suffixProduct=1;
        int max=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
         if(prefixProduct==0){
          prefixProduct=1;   
        }
         if(suffixProduct==0){
         suffixProduct=1;   
        }
        prefixProduct=prefixProduct*nums[i];
        suffixProduct=suffixProduct*nums[nums.length-i-1];
       
        max=Math.max(max,Math.max(prefixProduct,suffixProduct));
      
       } 
       return max;
    }
}