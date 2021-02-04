//Problem 84 :  Logger Rate Limiter
//TC: O(1)
//SC: O(1), because at most there will be 10 distinct messages i.e it will be constant space which is O(1)

/*Comments

//if insertion order of printed message log is required which means last printed message should always be on top then use hashmap with doubly linkedlist or LinkedHashMap just as LRU cache and remove/evict the node from tail if map size increases a threshold otherwise simply use hashmap to store message as key and timestamp as value and no need to delete anything
    
  //Note: Ask interviewer about is it required to save last log in top of the map or order doesn't matter and we dont have to delete/evict logs just like LRU cache. If he says order matters and last printed message should always be on top and evict the least recent one then go with HashMap and Doubly Linkedlist or LinkedHashMap just like LRU, otherwise go with simple hashmap i.e key as message and value as timestamp
  

*/
  //HashMap with doubly linked list
	import java.util.*;
	class LoggerDoublyWithHashMap {

        /** Initialize your data structure here. */
    
        class Node{
            Node prev,next;
            int timestamp;
            String message;
            
            Node(String message, int timestamp){
                this.message = message;
                this.timestamp = timestamp;
            }
        }
        
        private void addToHead(Node node){
            
            node.next = head.next;
            node.next.prev = node;
            
            head.next = node;
            node.prev = head;
            
        }
        
        private void removeFromTail(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        
        private Node head, tail;
        private Map<String,Node> map;
        
        public LoggerDoublyWithHashMap() {
            this.map = new HashMap<>();
            head = new Node("",-1);
            tail = new Node("",-1);
            head.next = tail;
            tail.prev = head;
        }
        
        
        
        
        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
            If this method returns false, the message will not be printed.
            The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            
            if(map.containsKey(message)){
                Node node = map.get(message);
                
                if(timestamp-node.timestamp<10) return false;
                
                node.timestamp = timestamp;
                addToHead(node);    
            }else{
                Node newNode = new Node(message,timestamp);
                
                if(map.size()==10){
                    Node tailPrev = tail.prev;
                    removeFromTail(tailPrev);
                    map.remove(tailPrev.message);
                }
                
                addToHead(newNode);
                map.put(message,newNode);
            }
            
            return true;
        }
    }
    
    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */