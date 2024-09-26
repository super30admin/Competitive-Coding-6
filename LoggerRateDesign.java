class Node{
    String message;
    int timestamp;
    Node prev; Node next;
    public Node(int timestamp,String message){
        this.message = message;
        this.timestamp = timestamp;
    }
   
}

class Logger {
    private static int maxSize = 10;
    private HashMap<String, Node> map;
    private Node head;
    private Node tail;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
        head = tail = new Node(0, ""); //circular linked list used here why used
        //tail = new Node(0, ""); //for doubly linked list dont use here why ?
        head.next = tail;
        tail.prev = head;
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */


/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        //search in map if yes
        if(map.containsKey(message)){
            Node temp = map.get(message);
            if(timestamp - temp.timestamp < maxSize) return false;
            moveToHead(temp,timestamp);
        }
        else {
            if (map.size()>= maxSize){
                removeFromTail();
             }
       
            addToHead(timestamp,message);
        }
        return true;
    }
   
    public void addToHead(int timestamp,String message){
        Node node = new Node(timestamp,message);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
        map.put(message,node);
    }
   
    private void removeFromTail(){
        this.tail.prev.next = this.tail.next;
        this.tail.next.prev = this.tail.prev;
        map.remove(this.tail.message);
    }
   
    private void moveToHead(Node temp,int timestamp){
        temp.timestamp = timestamp;
        //remove from current position
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        //adding to head
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
       
    }
}

/*
Time complexity :O(1) hashmap  and circular doubly linked list used
Space complexity : O(1)  

*/