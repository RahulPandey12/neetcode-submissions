class Solution {
    public boolean hasDuplicate(int[] nums) {
          List<Integer> alist =
                Arrays.stream(nums)
                      .boxed()
                      .collect(Collectors.toList());
      long count=alist.stream().filter(n->Collections.frequency(alist,n)>1).count();
      if(count>1) 
      return true;
      else {
        return false;
      }
    }
}