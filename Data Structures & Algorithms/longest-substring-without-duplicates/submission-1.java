class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int maxLength=0;
        HashSet<Character> hset= new HashSet<>();
        while(i<s.length() && j<s.length()){
        if(!hset.contains(s.charAt(j))){
            hset.add(s.charAt(j));
            j++;
        }
        else{
            hset.remove(s.charAt(i));
            i++;
        }
         maxLength=Integer.max(maxLength,j-i);
        }
        return maxLength;
    }
}
