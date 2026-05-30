class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> alist= new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
      for(int i=0;i<strs.length;i++){
        if (visited[i]) continue;
        List<String> blist= new ArrayList<>();
         blist.add(strs[i]);
         visited[i] = true;
        for(int j=i+1;j<strs.length;j++){
           
            if(!visited[j] && isAnagram(strs[i],strs[j])){
              blist.add(strs[j]);
              visited[j] = true;
            }
        }
        alist.add(blist);
      } 
      return alist; 
    }
    private boolean isAnagram(String a, String b){
        int freq[] = new int[26];
        if(a.length()!=b.length()){
            return false;
        }
        for(int i=0;i<a.length();i++){

           freq[a.charAt(i)-'a']++;
           freq[b.charAt(i)-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}
