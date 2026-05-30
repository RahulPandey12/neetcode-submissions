class Solution {
    public boolean isAnagram(String s, String t) {
       	char[] ch=s.toCharArray();
		 Arrays.sort(ch);
       
      char[] ch1=t.toCharArray();
		 Arrays.sort(ch1);
		  t=ch1.toString();
		 
      
		if (Arrays.toString(ch).equals(Arrays.toString(ch1))){ 
         return true;
      }
     return false;
    }
}
