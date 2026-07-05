class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> resultSet = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
               
                for(int k=j+1;k<nums.length;k++){
                    
                    if(nums[i]+nums[j]+nums[k]==0){
                         List<Integer> alist= new ArrayList<>();
                       alist.add(nums[i]);
                       alist.add(nums[j]);
                       alist.add(nums[k]);
                         Collections.sort(alist);
                  resultSet.add(alist);  
                    }
                }
               
            }
           
        }
        return resultSet.stream().collect(Collectors.toList());
    }
}
