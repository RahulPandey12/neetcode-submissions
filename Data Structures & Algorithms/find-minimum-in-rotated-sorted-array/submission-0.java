class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
         if (nums[left] <= nums[right]) {
                return nums[left];  // returns the ELEMENT
            }
            int mid=left+(right-left)/2;
            int next=(mid+1)%nums.length;
            int prev=(mid+nums.length-1)%nums.length;
            if((nums[mid]<nums[prev]) && (nums[mid]<nums[next])){
                return nums[mid];
            }
            else if(nums[left]<=nums[mid]){
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return nums[left];
    }
    
}