class Solution {
    int t[][];
    public int uniquePaths(int m, int n) {
        t= new int[m+1][n+1];
        for(int row[]: t){
            Arrays.fill(row,-1);
        }
      return uniquePathsHelper(m,n);
    }
    public int uniquePathsHelper(int m, int n){
         if(m==1 || n==1){
            return 1;
        }
        if(t[m][n]!=-1){
            return t[m][n];
        }
        return t[m][n]=uniquePathsHelper(m,n-1)+uniquePathsHelper(m-1,n);
    }
}
