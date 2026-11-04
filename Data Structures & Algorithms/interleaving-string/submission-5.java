class Solution {
 HashMap<String, Boolean> hmap = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length();
        int n=s2.length();
  
         if (m + n != s3.length()) {
            return false;
        }
        return isInterleaveHelper(s1,s2,s3,m,n);
    }
    public boolean isInterleaveHelper(String s1, String s2, String s3,int m, int n){
        int k=m+n;
        if(k==0){
            return true;
        }
        String key = m + "," + n;
        if(hmap.containsKey(key)){
            return hmap.get(key);
        }
        boolean include1=false;
        boolean include2=false;
        if(m>0 && s1.charAt(m-1)==s3.charAt(k-1))
           include1=isInterleaveHelper(s1,s2,s3,m-1,n);
         if(n> 0 && s2.charAt(n-1)==s3.charAt(k-1))
            include2=isInterleaveHelper(s1,s2,s3,m,n-1);
        hmap.put(key,(include1 || include2));
        return include1 || include2;
    }
}
