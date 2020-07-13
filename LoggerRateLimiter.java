/** Using HashMap
 * Time Complexity : O(1)
 * Space Complexity : O(n) where n = number of messages
 */

import java.util.*;
public class LoggerRateLimiter {
    Map<String,Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            if(timestamp - map.get(message)<10)
                return false;
        }
        map.put(message,timestamp);
        return true;
    }
}

/** Using Circular Doubly LinkedList
 * Time Complexity : O(1)
 * Space Complexity : O(1)
 * 
 */

class Logger {
    class Node{
        int time;
        String msg;
        Node prev;
        Node next;
        Node(int t, String m){                                                              // Doubly LL for time and message
            this.time = t;
            this.msg = m;
            this.prev = null;
            this.next = null;
        }
    }
    /** Initialize your data structure here. */
    HashMap<String, Node> store;
    public static int Max_time = 10;
    Node head;
    Node tail;
    public Logger() {
        this.store = new HashMap<>();                                                                       // Required initialisation
        this.head = new Node(-1, "");
        this.tail = new Node(-1, "");
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
            if(store.containsKey(message)){
                Node t = store.get(message);           
                int duration = timestamp - t.time;
                if(duration < Logger.Max_time) {                                                            // Violation
                return false;
                } else {
                    t.time = timestamp;                                                                     // Add the accessed node / updated node to the head
                    removeLRUTime(t);
                    addtoHead(t);
                }
                
            } else {
                if(store.size() == Logger.Max_time){                                                        // Capacity exceeding
                removeLRUTime(tail.prev);
                store.remove(tail.prev.msg);
                }
                Node new_node = new Node(timestamp, message);                                               // Create the new node
                store.put(message, new_node);
                addtoHead(new_node);                                                                    // Add the node to the head
                }
        return true;
    }
    private void addtoHead(Node n){
        n.prev = head;                                                                      // Adjust the pointers to add node to the head
        n.next = head.next;
        head.next = n;
        n.next.prev = n;
    }
    private void removeLRUTime(Node n){
        n.prev.next = n.next;                                                               // Remove the node from the current position
        n.next.prev = n.prev;
    }
}