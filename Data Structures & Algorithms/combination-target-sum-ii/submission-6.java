class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
          result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        solve(candidates,target,0,temp);
        return result;
    }
    public void solve(int[] nums, int target,int i,List<Integer> temp){
        if(target < 0)
         return;
        if(target==0){
             result.add(new ArrayList<>(temp));
            return ;
        }
         if(i==nums.length)
           return;
        temp.add(nums[i]);
        solve(nums,target-nums[i],i+1,temp);
        temp.remove(temp.size()-1);
int next = i + 1;
while(next < nums.length && nums[next] == nums[i]) {
    next++;
}
solve(nums, target, next, temp);
}
}