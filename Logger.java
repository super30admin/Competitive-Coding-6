/**

Map -> message -> timestamp
foo -> Node                          foo -> true, bar -> true, foo -> false
bar -> Node

int max_messages

->  foo, bar, foo, bar, foo, foo


linkedlist 6
 foo demo bar hello
 
 
 Node
 {
 string message
 int timestamp
 }

**/

class ListNode{
    String message;
    int timestamp;
    ListNode prev;
    ListNode next;
    
    ListNode(String message, int timestamp)
    {
        this.message = message;
        this.timestamp = timestamp;
        prev = null;
        next = null;
    }
}

class LinkedListCustom{
    ListNode head;
    ListNode tail;
    
    int size;
    
    LinkedListCustom()
    {
        head = null;
        tail = null;
        size = -1;
    }
    
    public ListNode insertAtTail(String message, int timestamp)
    {
        
        ListNode newNode = new ListNode(message, timestamp);
        
        if (tail == null)
        {
            tail = newNode;
            head = tail;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        size++;
        return newNode;
    }
    
    public void delteAtHead()
    {
        if (head == null)
        {
            return;
        }
        
        head = head.next;
        size--;
    }
    
    public void deleteGivenNode(ListNode node)
    {
        if (node == head)
        {
            head = head.next;
        }
        else
        {
            node.prev.next = node.next;
        }
        
        size--;
    }
    
    public int getSize()
    {
        return size;
    }
}


class Logger {
    
    Map<String, ListNode> messageToNode;
    LinkedListCustom LRUCache;
    int MAX_SIZE = 10;
    

    public Logger() {
        messageToNode = new HashMap<>();
        LRUCache = new LinkedListCustom();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if (messageToNode.containsKey(message))
        {
            ListNode messageInList = messageToNode.get(message);
            
            if (timestamp >= messageInList.timestamp + MAX_SIZE)
            {
                // print this message
                messageToNode.remove(message);
                LRUCache.deleteGivenNode(messageInList);
                ListNode newNode = LRUCache.insertAtTail(message, timestamp);
                messageToNode.put(message, newNode);
                return true;
            }
            
            if (LRUCache.getSize() == MAX_SIZE)
            {
                LRUCache.delteAtHead();
            }
             
            LRUCache.insertAtTail(message, timestamp);
            
            return false;
        }

            if (LRUCache.getSize() == MAX_SIZE)
            {
                LRUCache.delteAtHead();
            }
            
            ListNode insertedNode = LRUCache.insertAtTail(message, timestamp);
            messageToNode.put(message, insertedNode);
            
            return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
