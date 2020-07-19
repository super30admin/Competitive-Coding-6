# Time Complexity : O()
# Space Complexity : O() 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Node(object):

    def __init__(self, message, timeStamp):
        self.message = message
        self.timeStamp = timeStamp
        self.next = None
        self.prev = None
    
class Logger(object):
    def __init__(self,capacity):
        self.capacity = capacity
        self.map = {}
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)
        self.head.next = self.tail 
        self.tail.prev = self.head 
        
    # Time = O(1) | Space = O(1)
    def __insertAtHead(self,node):
        node.next = self.head.next
        self.head.next = node 
        node.next.prev = node 
        node.prev = self.head 
        return 
    
    # Time = O(1) | space = O(1)
    def __remove(self,node):
        node.next.prev = node.prev 
        node.prev.next = node.next 
        return 
    
    def shouldPrintMessage(self,timeStamp, message):
        if message in self.map:
            node = self.map[message] 
            self.__remove(node)
            self.__insertAtHead(node)
            if timeStamp - node.timeStamp < 10:
                return False 
            node.timeStamp = timeStamp 
            return True 
        
        else: 
            if len(self.map) == self.capacity:
                node = self.tail.prev 
                self.__remove(node)
                self.map.pop(node.message)
            self.map[message] = Node(message, timeStamp)
            node = self.map[message]
            self.__insertAtHead(node)
            return True 
    

def main():
    logger = Logger(10)
    print(logger.shouldPrintMessage(1, "foo"))     #   true
    print(logger.shouldPrintMessage(2, "bar"))     #   true
    print(logger.shouldPrintMessage(3, "foo"))     #   false
    print(logger.shouldPrintMessage(8, "bar"))     #   false
    print(logger.shouldPrintMessage(10, "foo"))    #   false
    print(logger.shouldPrintMessage(11, "foo"))    #   true
    
if __name__ == "__main__":
    main()