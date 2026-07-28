class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        HashMap<Character,Integer> hmap= new HashMap<>();
        int maxLength=0;
        while(j<s.length()){
         hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),0)+1);
         int maxFreq=0;
         for(int value:hmap.values()){
            maxFreq=Math.max(maxFreq,value);
         }
            if(j-i+1-maxFreq<=k){
                maxLength=Math.max(j-i+1,maxLength);
               
            }
           else if(j-i+1-maxFreq>k){
                 hmap.put(s.charAt(i),hmap.get(s.charAt(i))-1);
                 if(hmap.get(s.charAt(i))==0){
                    hmap.remove(s.charAt(i));
                   
                 }
                  i++;
                  maxFreq = 0;
                for (int value : hmap.values()) {
                    maxFreq = Math.max(maxFreq, value);
                }
            }
            j++;
        }
        return maxLength;
    }
}
