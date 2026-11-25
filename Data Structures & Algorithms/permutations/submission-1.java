class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        List<Integer> op=new ArrayList<>();
        List<Integer> ip=new ArrayList<>();
        for(int num:nums){
           ip.add(num);
        }
         permuteHelper(ip,op);
         return result;
        
    }
    public void permuteHelper(List<Integer> ip,List<Integer> op){
        if(ip.size()==0){
          result.add(new ArrayList<>(op));
          return;
        }
        for(int i=0;i<ip.size();i++){
            List<Integer> newIp=new ArrayList<>(ip);
            newIp.remove(i);
            List<Integer> newOp=new ArrayList<>(op);
            newOp.add(ip.get(i));
            permuteHelper(newIp,newOp);
        }
        
    }
}
