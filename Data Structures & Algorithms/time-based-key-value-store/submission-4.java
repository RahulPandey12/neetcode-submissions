class TimeMap {
    Map<String, List<Pair>> hmap;
    public TimeMap() {
       hmap= new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value,timestamp);
        hmap.computeIfAbsent(key,k->new ArrayList<>()).add(pair);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> alist=hmap.get(key);
        String res="";
        if(alist==null){
            return "";
        }
        int left=0;
        int right=alist.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            
            if(alist.get(mid).getTimestamp()<=timestamp){
                res=alist.get(mid).getValue();
                left=mid+1;
                
            }
            else {
              right=mid-1;  
            }
        }
        return res;

       
    }
}
class Pair {
    private String value;
    private Integer timestamp;
    public Pair(String value, Integer timestamp){
        this.value=value;
        this.timestamp=timestamp;
    }
    public void setValue(String val){
       this.value=val;
    }
    public String getValue(){
        return value;
    }
    public void setTimestamp(Integer timestamp){
       this.timestamp=timestamp;
    }
    public Integer getTimestamp(){
        return timestamp;
    }
}
