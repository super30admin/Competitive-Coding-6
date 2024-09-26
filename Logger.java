class Node {
    public int timestamp;
    public String message;
    public Node prev;
    public Node next;
    public Node(int timestamp, String message){
        this.timestamp = timestamp;
        this.message = message;
    }
}

class Logger {
    private static int Max_Time = 10;
    private HashMap<String, Node> map;
    private Node head;
    private Node tail;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
        head = tail = new Node(0, "");
        head.next = tail;
        tail.prev = head;
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            Node temp = map.get(message);
            if(timestamp - temp.timestamp < Logger.Max_Time) return false;
            moveToHead(temp, timestamp);
        } else {
            if(map.size() >= Logger.Max_Time) {
                removeTail();
            }
            addToHead(timestamp, message);
        }
        return true;
    }

    private void addToHead(int timestamp, String message){
        Node newNode = new Node(timestamp, message);
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next.prev = newNode;
        map.put(message, newNode);
    }

    private void removeTail(){
        this.tail.prev.next = this.tail.next;
        this.tail.next.prev = this.tail.prev;
        map.remove(this.tail.message);
    }

    private void moveToHead(Node temp,int timestamp){
        temp.timestamp = timestamp;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */