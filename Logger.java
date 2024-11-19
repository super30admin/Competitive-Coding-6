//Time Complexity O(1)
//Space Complexity O(N)
//LeetCode tested
import java.util.HashMap;

class LogNode{
    public String message;
    public int timestamp;
    public LogNode next;
    public LogNode prev;
    public LogNode(int timestamp,String message){
        //head = tail = new LogNode(0,"");
        this.timestamp = timestamp;
        this.message = message;
    }
}

public class Logger {
    public HashMap<String,LogNode> map;
    LogNode head,tail;
    public Logger(){
        map = new HashMap<>();
        head =tail =new LogNode(0,"");
        head.next = tail;
        tail.prev = head;
    }
    public boolean shouldPrintMessage(int timestamp,String message){
        if(map.containsKey(message)){
            LogNode temp = map.get(message);
            if(timestamp - temp.timestamp < 10) return false;
            moveToHead(temp,timestamp);
        }
        else{
            if(map.size()>=10){
                removeTail();
            }
            addToHead(timestamp,message);
        }
        return true;
    }

    public void addToHead(int timestamp,String message){
        LogNode newNode = new LogNode(timestamp,message);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        map.put(message,newNode);
    }
    private void removeTail(){
        this.tail.prev.next = this.tail.next;
        this.tail.next.prev = this.tail.prev;
        map.remove(this.tail.message);
    }
    private void moveToHead(LogNode temp,int timestamp){
        temp.timestamp = timestamp;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        addToHead(temp.timestamp,temp.message);
    }
}
