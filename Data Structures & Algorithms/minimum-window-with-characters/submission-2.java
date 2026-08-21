class Solution {
    public String minWindow(String s, String t) {
        int i=0;
        int j=0;
        int minLength=Integer.MAX_VALUE;
        String minSubString="";
        int start=0;
        HashMap<Character,Integer> hmap = new HashMap<>();

        for(Character ch:t.toCharArray()){
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }
        int count=hmap.size();
        while(j<s.length()){
            if(hmap.containsKey(s.charAt(j))){
                hmap.put(s.charAt(j),hmap.get(s.charAt(j))-1);
                if(hmap.get(s.charAt(j))==0){
                  count--;
                }
            }
        
            while(count==0){
            if(j-i+1<minLength){
                minLength=j-i+1;
                start=i;
            }
             
             if(hmap.containsKey(s.charAt(i))){
                if(hmap.get(s.charAt(i))==0){
                    count++;
                }
                hmap.put(s.charAt(i),hmap.get(s.charAt(i))+1);
                
            }
            i++;
           
        }
         j++;
        }
        if (minLength == Integer.MAX_VALUE) {
    return "";
}
return s.substring(start,start+minLength);
    }
}
