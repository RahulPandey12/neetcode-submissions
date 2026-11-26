class Solution {
    HashMap<Character,String> hmap=new HashMap<>();

    List<String> result;
    public List<String> letterCombinations(String digits) {
        result=new ArrayList<>();
        hmap=new HashMap<>();
         // ADDED: Handle empty input
        if(digits.length() == 0) {
            return result;
        }
        hmap.put('2',"abc");
        hmap.put('3',"def");
        hmap.put('4',"ghi");
        hmap.put('5',"jkl");
        hmap.put('6',"mno");
        hmap.put('7',"pqrs");
        hmap.put('8',"tuv");
        hmap.put('9',"wxyz");
        solve(digits,0,"");
        return result;
        
    }
    public void solve(String digits,int i,String op){
        if(i==digits.length()){
            result.add(op);
            return;
        } 
        String val=hmap.get(digits.charAt(i));
        for(int k=0;k<val.length();k++){
          solve(digits,i+1,op+val.charAt(k));
        }
          

     





    }
}
