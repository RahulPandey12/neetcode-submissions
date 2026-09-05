class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       for(int i=0;i<matrix.length;i++){
        int left=0;
        int right=matrix[i].length-1;
        int index=binarySearch(matrix[i],target, left,right);
        System.out.println(index);
        if(index!=-1)
           return true;
       } 
       return false;
    }
      public int binarySearch(int[] nums, int target,int left,int right){
          if (left > right) {
            return -1;
        }
        int mid =left+((right-left)/2);
        if(nums[mid]==target){
            return mid;
        }
       else if(nums[mid]<target){
          return binarySearch(nums,target,mid+1,right);
       }
       else if(nums[mid]>target){
        return binarySearch(nums,target,left,mid-1);
       }      
       return -1;
    
    }


}
