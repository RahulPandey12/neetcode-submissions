class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        subsetsHelper(nums,0,temp);
        return result;
    }
    public void subsetsHelper(int[] ip,int i,List<Integer> op){
        if(i==ip.length){
            result.add(new ArrayList<>(op));
            return;
        }
      op.add(ip[i]);
      subsetsHelper(ip,i+1,op);
       op.remove(op.size()-1);
       int next=i+1;
       while(next<ip.length && ip[next]==ip[i]){
        next++;
       }
      subsetsHelper(ip,next,op);
    }
}



