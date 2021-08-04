import java.util.HashMap;

class Node{
    public String message;
    public int timestamp;
    public Node head;
    public Node prev;
    public Node(int timestamp, String message){
        this.timestamp = timestamp;
        this.message = message;
    }
}

class Logger{
    public HashMap<String, Node> map;
    public static int Max_Time = 10;
    public Node head;
    public Node tail;
    public Logger(){
        map = new HashMap<String, Node>();
        head = tail = new Node(0, "");
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean shouldPrintMessage(int timestamp, String message){
        if(map.containsKey(message)){
            Node temp = map.get(message);
            if(timestamp - temp.timestamp<Logger.Max_Time){
                return false;
            }
            movetohead(temp, timestamp);
        }
        else{
            if(map.size() >= Logger.Max_Time){
                removeTail();
            }
            addtohead(timestamp, message);
        }
        return true;
    }
    
    public void addtohead(int timestamp, String message){
        Node newnode = new Node(timestamp, message);
        newnode.next = head.next;
        head.next = newnode;
        newnode.prev = head;
        newnode.next.prev = newnode;
        map.put(message, newnode);
    }
    
    private void removeTail(){
        this.tail.prev.next = this.tail.next;
        this.tail.next.prev = this.tail.prev;
        map.remove(this.tail.message);
    }
    
    private void movetohead(Node temp, int timestamp){
        temp.timestamp = timestamp;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = head;
    }
}