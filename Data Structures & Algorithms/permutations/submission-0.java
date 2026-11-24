class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        List<Integer> ip=new ArrayList<>();
        for(int num:nums){
           ip.add(num);
        }
         permuteHelper(ip,temp);
         return result;
        
    }
    public void permuteHelper(List<Integer> ip,List<Integer> temp){
        if(ip.size()==0){
          result.add(new ArrayList<>(temp));
          return;
        }
        for(int i=0;i<ip.size();i++){
            List<Integer> newIp=new ArrayList<>(ip);
            newIp.remove(i);
            List<Integer> newOp=new ArrayList<>(temp);
            newOp.add(ip.get(i));
            permuteHelper(newIp,newOp);
        }
        
    }
}
