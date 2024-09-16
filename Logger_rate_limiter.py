"""
// Time Complexity : o(1)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""
from collections import defaultdict
class Node: #mmainitaining a doubly LL
    def __init__(self,t, m):
        self.time = t
        self.msg = m
        self.prev = None
        self.next = None
        
class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map = defaultdict()
        self.capacity = 10 #timeframe of 10 sec
        self.head = Node(-1,"")
        self.tail = Node(-1,"")
        self.head.next = self.tail
        self.tail.prev = self.head
        
    def remove_node(self, n):
        n.prev.next = n.next
        n.next.prev = n.prev
        
    def add_to_head(self, n):
        n.next = self.head.next
        self.head.next = n
        n.prev = self.head
        n.next.prev = n
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message in self.map: #if the message is already there, compare the timestamp to see if it should be printed or not and update the node with new timestamp and place it at head
            ref = self.map[message]
            if timestamp - ref.time < self.capacity: #
                return False
            
            ref.time = timestamp
            
            self.remove_node(ref)
            self.add_to_head(ref)
            
        else: # else add the node the LL, remove the last node in the LL if timeframe of 10 sec is exceeded
            if len(self.map) == self.capacity:
                tail_ref = self.tail.prev
                
                self.remove_node(tail_ref)
                self.map.pop(tail_ref.msg)
                
            node = Node(timestamp,message)
            self.map[message] = node
            self.add_to_head(node)
        return True
            


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)