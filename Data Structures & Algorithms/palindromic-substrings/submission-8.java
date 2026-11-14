class Solution {
    int count=0;
    public int countSubstrings(String s) {
    for(int i=0;i<s.length();i++){
     countSubstringsHelper(s,i,i); //odd length
     countSubstringsHelper(s,i,i+1); //even length
    }
    return count;
    }
    public void countSubstringsHelper(String s, int left, int right){
        if(left<0 || right>=s.length())
        {
            return;
        }
        if(s.charAt(left)!=s.charAt(right)){
             return;
        }
        count++;
     
        countSubstringsHelper(s,left-1,right+1);

    
}
}
