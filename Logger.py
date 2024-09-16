"""
Time complexity 0(1)
Space complexity 0(N) hashmap 

"""
class Newnode:
    
    def __init__(self, timestamp, message):
        self.timest = timestamp
        self.msg = message
        self.prev = None
        self.next = None

class Logger:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.head = Newnode(-1, "")
        self.tail = Newnode(-1, "")
        self.hash = {}
        self.head.next=self.tail
        self.tail.prev=self.head

    def shouldPrintMessage(self, timestamp, message):
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message in self.hash:
            curr=self.hash[message]
            if timestamp - curr.timest< 10:
                return False
            curr.timest=timestamp
            self.moveTohead(curr)
        else:
            if(len(self.hash)>=10):
                removeAttail()
            self.addTohead(timestamp,message)
        return True
                
    def moveTohead(self,node):
        #remove node
        node.prev.next=node.next
        node.next.prev=node.prev
        #insert at head
        node.next=self.head.next
        node.prev=self.head
        self.head.next=node
        node.next.prev=node
    
    def removeAttail(self):
        self.tail.prev.next=self.tail.next
        self.tail.next.prev=self.tail.prev
        del self.hash[self.tail.message]
    
    def addTohead(self,timestamp,message):
        node=Newnode(timestamp,message)
        node.next=self.head.next
        node.prev=self.head
        self.head.next=node
        node.next.prev=node
        self.hash[message]=node
 
# Your Logger object will be instantiated and called as such:
#obj = Logger()
#param_1 = obj.shouldPrintMessage(timestamp,message)