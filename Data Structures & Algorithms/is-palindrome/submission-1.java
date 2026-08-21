class Solution {
    public boolean isPalindrome(String s) {
      // String s="Was it a car or a cat I saw";
	s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
	for(int i=0;i<s.length();i++) {
		if(s.charAt(i)!=s.charAt(s.length()-i-1)) {
			return false;
		}
		
	}
	return true;
    }
}
