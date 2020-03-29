'''
Time Complexity: O(1) -> to retrieve message
Space Complexity: O(M) -> M is size of unique messages
Did this code successfully run on Leetcode : Yes
Explanation: Use Hashmap of Node -> message to keep track of the messages and use a doubly linked list to keep the
messages. If the timestamp of the request is 10 seconds of the previous request then return True and move the requested
node to the front of the list, removing the tail.
'''
class Node:
    def __init__(self, message, timestamp):
        self.message = message
        self.timestamp = timestamp
        self.next = None
        self.prev = None


class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashMap = {}
        self.head = Node("", 0)
        self.tail = Node("", 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.size = 10
        self.maxDuration = 10


    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message in self.hashMap.keys():
            temp = self.hashMap[message]
            if timestamp - temp.timestamp < self.maxDuration:
                return False

            self.moveHead(temp, timestamp)
        else:

            if len(self.hashMap) >= self.size:
                self.removeTail

            self.insertFirst(message, timestamp)

        return True

    def insertFirst(self, message, timestamp):
        node = Node(message, timestamp)

        nextNode = self.head.next

        self.head.next = node

        node.prev = self.head
        node.next = nextNode

        nextNode.prev = node

        # insert Message
        self.hashMap[message] = node

    def removeTail(self):
        self.tail.prev.next = self.tail.next
        self.tail.next = self.tail.prev

        # delete message
        del self.hashMap[self.tail.message]

    def moveHead(self, node, timestamp):
        node.timestamp = timestamp
        node.prev.next = node.next
        node.next.prev = node.prev

        node.next = self.head.next
        node.prev = self.head
        self.head.next = node
        node.next.prev = node

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)