class Solution {
    int t[];
    public int numDecodings(String s) {
        t=new int[s.length()];
        Arrays.fill(t,-1);
      return numDecodingsHelper(s,0);
    }
    public int numDecodingsHelper(String s,int i){
        if(i==s.length()){
            return 1;
        }
         if(s.charAt(i)=='0'){
          return 0;
       }
       if(t[i]!=-1){
         return t[i];
       }
       //choice 1: one digit 
       int oneDigit=numDecodingsHelper(s,i+1);
       int twoDigit=0;
       if(i+1<s.length()){
        int x=Integer.parseInt(s.substring(i,i+2));
        if(x>=10 && x<=26){
            twoDigit= numDecodingsHelper(s,i+2);
        }
       }
       

       return t[i]=oneDigit+twoDigit;
    }
}
