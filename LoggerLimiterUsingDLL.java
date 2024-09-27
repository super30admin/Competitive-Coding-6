class Node {
    public String message;
    public int timeStamp;
   
    public  Node next;
    public Node prev;
    public Node(int timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message = this.message;
    }
}

class Logger {
    public HashMap<String, Node> map;
    public Node head;
    public Node temp;
    public Node tail;
     public static int Max_Time = 10;
    /** Initialize your data structure here. */
    public Logger() {
        map  = new HashMap<>();
        head = tail = new Node(0,"");
        head.next = tail;
        tail.prev = head;
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timeStamp, String message) {
        //check the message exist or not
        if(map.containsKey(message)) {
            Node temp = map.get(message);
            if(timeStamp - temp.timeStamp<Logger.Max_Time) return false;
            movetoHead(temp,timeStamp);
        } else {
            if(map.size() >= Logger.Max_Time) {
                removeTail();
            }
            addtoHead(timeStamp, message);
        }
        return true;
    }
    public void addtoHead(int timeStamp, String message) {
        Node newNode = new Node(timeStamp, message);
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next.prev = newNode;
        map.put(message,newNode);
        
    }
    private void removeTail() {
        this.tail.prev.next = this.tail.next;
        this.tail.next.prev = this.tail.prev;
        map.remove(this.tail.message);
        
    }
    private void movetoHead(Node temp, int timeStamp) {
        temp.timeStamp = timeStamp;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next =  head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev.prev = temp;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */