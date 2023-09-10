// Time Complexity - O(1) -- similar to LRU cache
// Space Complexity - O(1) -- not sure as anything from the class is not part of what user sees

import java.util.*;
class Logger{
    class Node{
        public String message;
        public int timestamp;
        public Node next;
        public Node prev;
        Node(String message,int timestamp){
            this.message = message;
            this.timestamp = timestamp;
        }
    }
    HashMap<String,Node> map;
    Node head;
    Node tail;
    public static int maxTime = 10; 
    Logger(){
        this.head = new Node("",0);
        this.tail = new Node("",0);
        this.map = new HashMap<>();
        head.next = tail;
        tail.prev = head; 
    }
    
    private void addToHead(Node curr){
        curr.prev = head;
        curr.next = head.next;
        head.next = curr;
        curr.next.prev = curr;
    }

    private void removeFromTail(Node curr){
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    public boolean shouldPrintMessage(int timestamp, String message){
        if(map.containsKey(message)){
            Node temp = map.get(message);
            temp.timestamp = timestamp;
            if(timestamp - temp.timestamp <= Logger.maxTime) return false;
            removeFromTail(temp);
            addToHead(temp);
            
        }else{
            if(map.size()>=Logger.maxTime){
                Node temp = tail.prev;
                temp.prev.next = tail;
                tail.prev = temp.prev;
            }
            Node temp1 = new Node(message,timestamp);
            addToHead(temp1);
            map.put(message,temp1);
        }
        return true;
    }

}