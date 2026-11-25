class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        int n=nums.length;
        subsetsHelper(nums,0,temp);
        return result;
    }
    public void subsetsHelper(int[] ip,int i,List<Integer> op){
        if(i==ip.length){
            result.add(new ArrayList<>(op));
            return;
        }
       
      List<Integer> newOp=new ArrayList<>(op);
      newOp.add(ip[i]);
      subsetsHelper(ip,i+1,newOp);
      subsetsHelper(ip,i+1,op);
    }
}
