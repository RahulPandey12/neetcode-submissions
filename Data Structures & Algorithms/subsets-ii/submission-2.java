class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
        HashSet<Integer> hset= new HashSet<>();
          
            int op1=ip[n-1];
            op.add(op1);
       subsetsHelper(ip,n-1,new ArrayList<>(op));
       // EXCLUDE
op.remove(op.size()-1);
        int next = n-1;
        // Skip duplicate elements
        while (next > 0 && ip[next] == ip[next-1]) {
            next--;
        }
       subsetsHelper(ip,next,new ArrayList<>(op));
           
    }
}

