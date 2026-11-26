class Solution {
    List<List<String>> result;
    List<String> temp= new ArrayList<>();
    public List<List<String>> partition(String s) {
        result=new ArrayList<>();
        int n=s.length();
        partitionHelper(s,0,n-1);
        return result;
        
    }
    public void partitionHelper(String s,int i,int j){
        if(i>j){
            result.add(new ArrayList<>(temp));
            return ;
        }
        for(int k=i;k<=j;k++){
            
            if(isPalindrom(s,i,k)){
                temp.add(s.substring(i,k+1));
                partitionHelper(s,k+1,j);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalindrom(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
