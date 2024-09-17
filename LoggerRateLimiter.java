// Time Complexity : O(n), number of input with different timestamps
// Space Complexity : O(10), Max_Time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Logger {
    //create a class Node with key and value
    //node next and node prev
    class Node{
        String message; 
        int timestamp;
        Node next;
        Node prev;
        
        //create a constructor and initialize value for key and value 
        public Node(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }
    
    HashMap<String, Node> map;
    static int Max_Time = 10;
    Node head;
    Node tail;      
    public Logger() {
        map = new HashMap<>();
        head = new Node(0, "");
        tail = new Node(0, "");
        head.next = tail;
        tail.prev = head;         
    }
    
    //add recently accessed (get/put) node to head
    public void addToHead(int timestamp, String message) {
        Node newNode = new Node(timestamp, message);
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        newNode.next.prev = newNode;
        map.put(message, newNode);
    }
    
    public void moveToHead(Node node, int timestamp) {
        node.timestamp = timestamp;
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
    
    public void removeLast() {
        Node removeNode = tail.prev;
        removeNode.next.prev = removeNode.prev;
        removeNode.prev.next = removeNode.next;
        map.remove(removeNode.message);
    }
    
      
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        //check if node with key value already exists
        if(map.containsKey(message)) {
            //get the node wrt the key
            Node node = map.get(message);
            if(timestamp - node.timestamp < Logger.Max_Time) return false;
            moveToHead(node, timestamp);
        }
        else
        {
            if(map.size()>= Logger.Max_Time) {
                removeLast();
            }
            addToHead(timestamp, message);
        }
        return true;        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

