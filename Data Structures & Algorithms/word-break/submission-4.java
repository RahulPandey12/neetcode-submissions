class Solution {
    Boolean dp[][];
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int n1=wordDict.size();
        dp= new Boolean[n+1][n1+1];
       return wordBreakHelper(s,wordDict,0,0);
    }
     public boolean wordBreakHelper(String s, List<String> wordDict,int index,int dictIndex) {
        if(s.length()==index){
            return true;
        }
        if(dictIndex==wordDict.size())
           return false;
        if(dp[index][dictIndex]!=null){
              return dp[index][dictIndex];
        }
        String word=wordDict.get(dictIndex);
        boolean include=false;
        if(s.startsWith(word,index))
           include=wordBreakHelper(s,wordDict,index+word.length(),0);
       boolean exclude=wordBreakHelper(s,wordDict,index,dictIndex+1);
     return dp[index][dictIndex]=(include || exclude);
    }
}
