class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String,List<String>> hmap = new HashMap<>();
       List<List<String>> blist= new ArrayList<>();
       for(int i=0;i<strs.length;i++){
        char ch[]=strs[i].toCharArray();
        Arrays.sort(ch);
        String key=Arrays.toString(ch);
       
        hmap.computeIfAbsent(key,k->new ArrayList<>());
        hmap.get(key).add(strs[i]);
       }
       for( Map.Entry<String,List<String>> entry:hmap.entrySet()){
        blist.add(entry.getValue());
       }
       return blist;
    }
    
}
