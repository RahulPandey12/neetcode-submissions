class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        int m=n;
        helper(n,m,"");
        return result;
    }
    public void helper(int n, int m,String op){
        if(n==0 && m==0){
            result.add(op);
            return;
        }
        String choice1="(";
        String choice2=")";
        if(n>0){
        helper(n-1,m,op+choice1);
        }
        if(m>n)
        helper(n,m-1,op+choice2);
    }
}
