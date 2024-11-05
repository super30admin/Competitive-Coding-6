class Logger {
    HashMap <String,Integer> map;
    public Logger() {
        map=new HashMap();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(map.get(message)>timestamp-10){
                return false;
            }
        }        
        map.put(message,timestamp);
        return true;
    }
}
