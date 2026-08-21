class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int maxLength=0;
        HashSet<Character> hset= new HashSet<>();
        while(j<s.length()){
       while(hset.contains(s.charAt(j))){
          hset.remove(s.charAt(i));
           i++;
       }
       if(!hset.contains(s.charAt(j))){
        hset.add(s.charAt(j));
        maxLength=Integer.max(j-i+1,maxLength);
        j++;
       }
        }
       return maxLength;
    }
}
