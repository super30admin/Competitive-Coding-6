// Time Complexity : O(1)
// Space Complexity : O(n) ->space of HashMap and LinkedList
// Did this code successfully run on Leetcode : Yes


import java.util.HashMap;

public class LoggerRateLimiterWithLRUImpl {
    HashMap<String,Node> map;
    Node head;
    Node tail;
    static int capacity;

    class Node {
        String message;
        int timestamp;
        Node next;
        Node prev;

        public Node(String message, int timestamp)
        {
            this.message = message;
            this.timestamp = timestamp;
        }
    }

    public LoggerRateLimiterWithLRUImpl() {
        map = new HashMap<>();
        this.capacity = 10;
        this.head = new Node("",0);
        this.tail = new Node("",0);
        head.next = tail;
        tail.prev = head;
    }

    public void addToHead(Node node)
    {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    public void removeNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message))
        {
            Node temp = map.get(message);
            removeNode(temp);
            addToHead(temp);

            if(timestamp < temp.timestamp+10)
            {
                //move node to front
                return false;
            }else{
                temp.timestamp = timestamp;
                return true;
            }
        }else{
            Node newNode = new Node(message, timestamp);

            if(map.size() > LoggerRateLimiterWithLRUImpl.capacity)
            {
                Node tailPrev = tail.prev;
                map.remove(tailPrev.message);
                removeNode(tail.prev);
            }
            addToHead(newNode);

            map.put(message,newNode);
            return true;
        }

    }

    /*public void display()
    {
        Node temp = head;
        while(temp.next !=null)
        {
            System.out.print("Message   :  "+temp.message+"   ");
            System.out.print("TimeStamp   :  "+temp.timestamp);
            System.out.println(" ");

            temp = temp.next;
        }
    }*/

}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */