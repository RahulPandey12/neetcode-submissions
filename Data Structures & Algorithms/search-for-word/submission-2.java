class Solution {
    int[][] dir={{-1,0},{0,-1},{0,1},{1,0}};
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
             if(solve(board,word,i,j,n,m,"")){
                return true;
             }
            }
        }
        return false;
    }
    public boolean solve(char[][] board, String word,int x, int y,int n, int m ,String op){
        if(x<0 || x>=n || y<0 || y>=m){
            return false;
        }
        if(board[x][y]=='#' || board[x][y]!=(word.charAt(op.length()))){
            return false;
        }
        op=op+board[x][y];
        if(op.equals(word)){
            return true;
        }
        char temp=board[x][y];
        board[x][y]='#';
        for(int k=0;k<4;k++){
            int newX=x+dir[k][0];
            int newY=y+dir[k][1];
            if( solve(board,word,newX,newY,n,m,op)){
                 board[x][y]=temp;
                return true;
            }

        }
        board[x][y]=temp;
        return false;

    }
}
