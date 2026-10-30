class Solution {
    boolean dp[][];
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        int n1=wordDict.size();
        dp= new boolean[n+1][n1+1];
         for(int j=0;j<n1+1;j++){
            dp[0][j]=true;
       }
         for(int i=1;i<n+1;i++){
            dp[i][0]=false;
         }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n1+1;j++){
                String word=wordDict.get(j-1);
                int len=word.length();
                boolean include=false;
            if(i >= len && s.startsWith(word,i - len))
              include=dp[i-len][n1];
           boolean exclude=dp[i][j-1];
            dp[i][j]=include || exclude;
            }
        }
        
     return dp[n][n1];
    }
}
