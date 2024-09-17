'''

TC: O(1)
SC: O(1) on average

Intuition: Maintain linked list and hashmap to storage message and nodes resp. Using linked list because to save space 
where we can remove older nodes
'''
class Node:
    def __init__(self, message, ts):
        self.message = message
        self.timestamp = ts
        self.next = None
        self.prev = None
        
class Logger:

    def __init__(self):
        self.head = Node(None, None)
        self.tail = Node(None, None)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.hmap = dict()
        self.max_time = 10
        self.c = 0
        
    def eject_tail(self, timestamp):
        if self.c <= self.max_time:
            return
        n = self.tail.prev
        if n.timestamp + 10 <= timestamp:
            n.prev.next = self.tail
            self.tail.prev = n.prev
            self.hmap.pop(n.message)
            self.c -= 1
    
    def remove_node(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev
        
    def move_to_head(self, node):
        temp = self.head.next
        if node.next or node.prev:
            self.remove_node(node)
        self.head.next = node
        node.prev = self.head
        node.next = temp
        temp.prev = node
        
    def add_node(self, timestamp, message):
        node = self.hmap[message]
        node.timestamp = timestamp
        node.message = message
        self.eject_tail(timestamp)
        self.move_to_head(node)
        self.hmap[message] = node
    
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.hmap:
            node = self.hmap[message]
            if node.timestamp + 10 <= timestamp:
                self.add_node(timestamp, message)
            else:
                return False
        else:
            self.hmap[message] = Node(message, timestamp)
            self.c += 1
            self.add_node(timestamp, message)
            
        return True
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)