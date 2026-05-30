class Solution {
    public boolean hasDuplicate(int[] nums) {
      HashSet<Integer> hset= new HashSet<>();
      for(int x : nums)
      if(!hset.add(x))
      return true;
      
        return false;
      
    }
}