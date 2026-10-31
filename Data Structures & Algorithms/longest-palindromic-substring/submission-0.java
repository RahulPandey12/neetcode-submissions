class Solution {
    int maxLen=Integer.MIN_VALUE;
    int start=0;
    public String longestPalindrome(String s) {
    for(int i=0;i<s.length();i++){
     longestPalindromeHelper(s,i,i); //odd length
     longestPalindromeHelper(s,i,i+1); //even length
     
    }
    return s.substring(start,start+maxLen);
    }
    public void longestPalindromeHelper(String s, int left, int right){
        if(left<0 || right>=s.length())
        {
            return;
        }
        if(s.charAt(left)!=s.charAt(right)){
             return;
        }
        int len=right-left+1;
        if(len>maxLen){
            maxLen=len;
            start=left;
        }
        longestPalindromeHelper(s,left-1,right+1);

    }
    
}