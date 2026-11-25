class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        int m=n;
        StringBuilder sb=new StringBuilder();
        helper(n,m,sb);
        return result;
    }
    public void helper(int n, int m,StringBuilder op){
        if(n==0 && m==0){
            result.add(op.toString());
            return;
        }
        String choice1="(";
        String choice2=")";
        if(n>0){
        op.append("(");
        helper(n-1,m,op);
        op.deleteCharAt(op.length()-1);
        }
        if(m>n){
        op.append(")");
        helper(n,m-1,op);
        op.deleteCharAt(op.length()-1);
        }
       
    }
}
