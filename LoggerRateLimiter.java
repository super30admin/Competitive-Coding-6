package Nov25;

import java.util.HashMap;
import java.util.Map;

class LoggerRateLimiter {
    
    /*
    Time complexity: O(1)
    Time complexity is constant as accessing the elements in hashmap is O(1) and reference for nodes of LL is saved in map as entry values.  
    
    Space complexity: O(1) 
    Map and linked list size is always maintained as 10.
    */
    
    
    Map<String, Node> hm;
    
    class Node {
        String msg;
        int time;
        Node next;
        Node prev;
        public Node(String m, int t) {
            msg = m;
            time = t;
        }
    }
    
    Node head;
    Node tail;
    
    /** Initialize your data structure here. */
    public Logger() {
       hm = new HashMap<>();
       head = new Node("", 0);
       tail = new Node("", 0);
       head.next = tail;
       tail.prev = head; 
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if (hm.containsKey(message)) {
            Node curNode = hm.get(message);
            if (timestamp - curNode.time >= 10) {
                // update timestamp in cur node
                curNode.time = timestamp;
                // remove curNode from current position in LL
                removeNode(curNode);
                // add curNode to head in LL
                addNodeToHead(curNode);
                return true;
            } else {
                return false;
            }
        } // hm doesnt contain incoming msg 
        else {
             // create a new node
            Node newNode = new Node(message, timestamp);
            
            if (hm.size() >= 10) {
                // delete tail node from map and LL
                hm.remove(tail.prev.msg);
                deleteNodeFromTail(); 
            } 
            
            // add new node to head of LL 
            addNodeToHead(newNode);
            // add new node in map
            hm.put(message, newNode);
            
           return true;
        }
    }
    
    private void removeNode (Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    } 
    
    private void addNodeToHead (Node node) {
        // head -->  node -->  n
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    
    private void deleteNodeFromTail () {
        // n1 --> n2 --> tail
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
