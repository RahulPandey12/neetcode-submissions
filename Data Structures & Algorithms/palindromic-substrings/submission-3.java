class Solution {
    int count=0;
     int maxLen=Integer.MIN_VALUE;
    int start=0;
    public int countSubstrings(String s) {
    for(int i=0;i<s.length();i++){
     longestPalindromeHelper(s,i,i); //odd length
     longestPalindromeHelper(s,i,i+1); //even length
    }
    return count;
    }
    public void longestPalindromeHelper(String s, int left, int right){
        if(left<0 || right>=s.length())
        {
            return;
        }
        if(s.charAt(left)!=s.charAt(right)){
             return;
        }
        count++;
        int len=right-left+1;
        if(len>maxLen){
            maxLen=len;
            start=left;
        }
        longestPalindromeHelper(s,left-1,right+1);

    
}
}
