class Solution {
    int t[];
    public int numDecodings(String s) {
        int n=s.length();
        t=new int[n+1];
        t[n]=1;
         
      for(int i=s.length()-1;i>=0;i--){
            
        if(s.charAt(i)=='0'){
         t[i]=0;
         continue;
       }
       //choice 1: one digit 
       int oneDigit=t[i+1];
       int twoDigit=0;
       if(i+1<s.length()){
        int x=Integer.parseInt(s.substring(i,i+2));
        if(x>=10 && x<=26){
            twoDigit= t[i+2];
        }
        
       }
       t[i]=oneDigit+twoDigit;
      }
       

       return t[0];
    }
   
}
