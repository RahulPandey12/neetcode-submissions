class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

       	int fq[]=new int[26];
        for(int i=0;i<s.length();i++){
            fq[s.charAt(i)-'a']++;
            fq[t.charAt(i)-'a']--;
        }
        for(int x: fq){
            if(x!=0)
            {
                return false;
            }
        }
     return true;
    }
}
