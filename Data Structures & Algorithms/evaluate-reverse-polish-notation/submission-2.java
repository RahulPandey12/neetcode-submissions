class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int result=1;
        if(tokens.length==1){
            return Integer.parseInt(tokens[0]);
        }
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("+") 
            && !tokens[i].equals("-") 
            && !tokens[i].equals("*") 
            && !tokens[i].equals("/") ){
                //System.out.println(i);
                stack.push(tokens[i]);
            }
            else{
                 //System.out.println("+++++");
               //  System.out.println(i);
               int secondOperand = Integer.parseInt(stack.pop());
               int firstOperand= Integer.parseInt(stack.pop());
                if(tokens[i].equals("+")){
                    result=firstOperand+secondOperand;
                    
                }
                else if(tokens[i].equals("-")){
                    result=firstOperand-secondOperand;
                }
                 else if(tokens[i].equals("*")){
                    result=firstOperand*secondOperand;
                }
                 else if(tokens[i].equals("/")){
                    result=firstOperand/secondOperand;
                }
                
                stack.push(String.valueOf(result));
            }
        }
        return result;
    }
}
