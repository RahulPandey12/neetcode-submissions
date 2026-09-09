class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){
           return findMedianSortedArrays(nums2,nums1); 
        }
        int total=m+n;
        int leftSize=(total+1)/2;
        int left=0;
        int right=m;
        while(left<=right){
            int mid1=left+(right-left)/2;
            int mid2=leftSize-mid1;
            int left1=mid1==0?Integer.MIN_VALUE:nums1[mid1 - 1];
            int left2=mid2==0?Integer.MIN_VALUE:nums2[mid2-1];
            int right1=mid1==nums1.length?Integer.MAX_VALUE:nums1[mid1];
            int right2=mid2==nums2.length?Integer.MAX_VALUE:nums2[mid2];
            if((left1<=right2) && (left2<=right1)){
                if(total%2==1){
                    return Math.max(left1,left2);
                }
            return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }
            else if(left1>right2)
            {
                right=mid1-1;
            }
            else if(left2>right1){
                left=mid1+1;
            }
        }
         return 0.0;
    }
}
