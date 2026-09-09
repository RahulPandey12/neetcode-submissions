class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++){
           high= Math.max(piles[i],high);
        }
        int res=-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(isValid(piles,h,mid)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
        public boolean isValid(int[] piles, int h, int mid){
           long time=0;
        for(int n: piles) {
         time=time+(long)Math.ceil((double)n/(double)mid);
        }
            if(time<=h){
                return true;
            }
            return false;
        }
    }

