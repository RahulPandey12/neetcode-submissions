class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int n=nums.length;
        subsetsHelper(nums,n,temp);
        return result;
    }
    public void subsetsHelper(int[] ip,int n,List<Integer> op){
        if(n==0){
            result.add(new ArrayList<>(op));
            return;
        }

      op.add(ip[n-1]);
      subsetsHelper(ip,n-1,op);
       op.remove(op.size()-1);
      subsetsHelper(ip,n-1,op);
    }
}
