class TimeMap {
    HashMap<String,List<Pair>>hm;
    
    public class Pair{
        String value;
        int timestamp;
        Pair(String value,int timestamp)
        {
            this.value=value;
            this.timestamp=timestamp;
        }
    }
    
    public TimeMap() {
        hm=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key))
        hm.put(key,new ArrayList<>());
        
        hm.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key))
            return "";
        List<Pair> p=hm.get(key);
        int lo=0,hi=p.size()-1;
        String prev="";
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(p.get(mid).timestamp==timestamp)
            {
                prev=p.get(mid).value;
                return prev;
            }
            else if(p.get(mid).timestamp<timestamp)
            {
                prev=p.get(mid).value;
                lo=mid+1;
                
            }
            else
                hi=mid-1;
        }
        return prev;
        
    }
}
