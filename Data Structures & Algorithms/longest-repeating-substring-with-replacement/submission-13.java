class Solution {
    public int characterReplacement(String s, int k) {
       int i=0;
       int j=0;
       int maxFreq=0;
       int maxLength=0;
       HashMap<Character,Integer> hmap= new HashMap<>();
       while(j<s.length()){
        hmap.put(s.charAt(j),hmap.getOrDefault(s.charAt(j),0)+1);
        for(Integer val:hmap.values()){
            maxFreq= Math.max(maxFreq,val);
        }
        if(j-i+1-maxFreq<=k){
            maxLength=Math.max(j-i+1,maxLength);
            j++;
        }
        else if(j-i+1-maxFreq>k){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)-1);
            if(hmap.get(s.charAt(i))==0){
                hmap.remove(s.charAt(i));
            }
            i++;
            j++;
            maxFreq=0;
            for(Integer val:hmap.values()){
            maxFreq= Math.max(maxFreq,val);
        }
        }
       }
       return maxLength;
    }
}
