// Time Complexity : O(n) for n number of messages having n hashmap lookups for Approach 1 and 2
// Space Complexity : O(n) for Approach 1 and O(1) for Approach 2 for storing 10 messages only at every instance
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: As the messages arrive store the messages in form of a message as key and timestamp
as value. As you receive duplicate message, fetch the earlier timestamp of the message and check if it is lesser than 10 seconds, if it is, display
false else true.
*/

// APPROACH 1 - USING HASHMAP WITH SPACE O(N) 
class Logger {
    
    HashMap<String, Integer> store;
    /** Initialize your data structure here. */
    public Logger() {
        store = new HashMap<>();                                                    // Store message and timestamp
        
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(store.containsKey(message)){                                         // Duplicate message
            int t = store.get(message);                                 
            int duration = timestamp - t;
            if(duration < 10){return false;}                                                // if duration is < 10 return false
        }
        store.put(message, timestamp);                                                                  // Store the latest message
        return true;
    }
}

// APPROACH 2 - USING HASHMAP WITH SPACE O(1) ASSUMING 10 IS THE MAX CAPACITY 
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
