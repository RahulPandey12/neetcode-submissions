class Solution {
    public int trap(int[] height) {
        int totalWater=0;
        int leftMax =0;
        int rightMax =0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }
                else{
                   totalWater =totalWater+(leftMax-height[left]);
                }
                    left++;
            }
            else{
                 if(height[left]>height[right]){
                if(height[right]>rightMax){
                    rightMax=height[right];
                }
                else{
                   totalWater =totalWater+(rightMax-height[right]);
                }
                right--;
            }
        }
        }
        return totalWater;
    }
}
