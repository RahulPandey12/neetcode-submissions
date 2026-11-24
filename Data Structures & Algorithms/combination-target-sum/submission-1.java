class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(nums,target,0,temp);
        return result;
        
    }
    public void solve(int[] nums, int target,int i,List<Integer> temp){
        if(target < 0)
         return;
        if(target==0){
            result.add(new ArrayList<>(temp));
            return;
        }
         if(i==nums.length)
           return;
        temp.add(nums[i]);
        solve(nums,target-nums[i],i,temp);
        temp.remove(temp.size()-1);
        solve(nums,target,i+1,temp);
    
        
    }
}
