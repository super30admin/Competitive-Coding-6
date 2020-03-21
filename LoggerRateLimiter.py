'''
Solution:
1.  In order to design LoggerRateLimiter Cache, we need Doubly-Linked-List to store cache which makes it O(1) operation
    to remove a node from any position and also to insert at the Head (this is the place to store most recently
    accessed element).
2.  We also use a HashMap to store node's message and its timeStamp (complete Node object) for faster access.
3.  Two helper functions to remove node and insert node at head.

Time and Space Complexities of all functions are O(1) with an extra space O(capacity) for both HashMap and DLL
'''


class Node(object):

    #   Node which is part of a Doubly-Linked-List having a message, timestamp, nextNode reference and previousNode reference

    def __init__(self, message, timeStamp):
        self.message = message
        self.timeStamp = timeStamp
        self.next = None
        self.prev = None


class Logger(object):

    def __init__(self, capacity):

        self.capacity = capacity

        self.head = Node(-1, -1)  # dummy head
        self.tail = Node(-1, -1)  # dummy tail
        self.head.next = self.tail  # head's next is initially pointing to tail
        self.tail.prev = self.head  # tail's prev is initially pointing to head

        self.messageNodeMap = {}  # HashMap to store node's message as Node containing message and timeStamp itself as Map's value

    def __insertAtHead(self, node):

        #   Time Complexity:    O(1)    |   Space Complexity:   O(1)
        #   insert's a node at the head position (next node of dummy head)

        #   make correct references to the next and prev of the node in consideration
        node.prev = self.head
        node.next = self.head.next

        #   attach node's reference to dummy head and node's next node
        self.head.next = node
        node.next.prev = node

        return

    def __remove(self, node):

        #   Time Complexity:    O(1)    |   Space Complexity:   O(1)
        #   removes a node keeping intact its next and prev nodes.
        node.prev.next = node.next
        node.next.prev = node.prev

        return

    def shouldPrintMessage(self, timeStamp, message):

        if (message in self.messageNodeMap):

            node = self.messageNodeMap[message]         # retrieve the corresponding node

            self.__remove(node)                         # remove the node from current position
            self.__insertAtHead(node)                   # add it to the front of the DLL as it is accessed latest

            if (timeStamp - node.timeStamp) < 10:       # return false and no need to update the timeStamp
                return False

            node.timeStamp = timeStamp                  # else update the timeStamp and return true
            return True

        else:
            if (len(self.messageNodeMap) == self.capacity):           # if capacity is maximum
                node = self.tail.prev                                 # capture the tail node (least recently used)
                self.__remove(node)                                   # remove the node from current position
                self.messageNodeMap.pop(node.message)                 # remove the node from HashMap

            self.messageNodeMap[message] = Node(message, timeStamp)   # place the node in the HashMap
            node = self.messageNodeMap[message]                       # capture the actual node using message from HashMap
            self.__insertAtHead(node)                                 # add it to the front of the DLL as it is accessed latest

            return True                                               # return true


logger = Logger(10)
print(logger.shouldPrintMessage(1, "foo"))     #   true
print(logger.shouldPrintMessage(2, "bar"))     #   true
print(logger.shouldPrintMessage(3, "foo"))     #   false
print(logger.shouldPrintMessage(8, "bar"))     #   false
print(logger.shouldPrintMessage(10, "foo"))    #   false
print(logger.shouldPrintMessage(11, "foo"))    #   true