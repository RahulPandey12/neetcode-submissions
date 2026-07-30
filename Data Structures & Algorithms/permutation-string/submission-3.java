class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> hmap = new HashMap<>();
        for(char ch : s1.toCharArray()){
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }
        int k=s1.length();
        int i=0;
        int j=0;
        int count=hmap.size();
        while(j<s2.length()){
        if(hmap.containsKey(s2.charAt(j))){
            hmap.put(s2.charAt(j),hmap.get(s2.charAt(j))-1);
            if(hmap.get(s2.charAt(j))==0){
                  count--;
               }
        }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(count==0){
                    return true;
                }
              if (hmap.containsKey(s2.charAt(i))) {

    if (hmap.get(s2.charAt(i)) == 0)
        count++;

    hmap.put(s2.charAt(i), hmap.get(s2.charAt(i)) + 1);
}
              i++;
              j++;
            }
           
        }
return false;
    }
}
