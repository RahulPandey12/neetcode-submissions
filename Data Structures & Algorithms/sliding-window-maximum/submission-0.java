class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=0;
      Deque<Integer> queue = new ArrayDeque();
        int result[] = new int[nums.length-k+1];
        while(j<nums.length){
            while(!queue.isEmpty() && nums[j]>queue.getLast()){
                queue.removeLast();
            }
           queue.addLast(nums[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
               result[i]= queue.getFirst();
               if(nums[i]==queue.getFirst()){
                queue.removeFirst();
               }
               i++;
               j++;
            }
        }
        return result;
    }
}
