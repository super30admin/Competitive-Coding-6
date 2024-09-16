'''
    Time Complexity:
        O(1)
        (updating value in a HashMap, adding node to the head of a DoublyLinkedList,
        moving specific node to the head, or removing tail - they all are constant
        time operationrs)

    Space Complexity:
        O(1) (max size of the HashMap and DoublyLinkedList would be 10)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Maintain a DoublyLinkedList (Node: message, timestamp, prev, next),
            and a HashMap {message: Node}.

        If the message is in the HashMap,
            -> If the message in the HashMap is younger than 10 seconds, return False
            -> Else, update the timestamp of the node of the message,
                and move the node to the head (because this is our most recent
                message now.)
        Else,
            -> Add a node of (message, timestamp) to the head of the List.
            -> Add the node (mapped to the message) in the HashMap.
            -> If the length of the HashMap > 10,
                -> Remove the tail of the list.
                -> Delete the message corressponding to the removed node from the HashMap.
'''

class Logger:
    TIME_FRAME = 10

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dll = DoublyLinkedList()
        self.lookup = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message in self.lookup:
            message_node = self.lookup[message]
            if timestamp - message_node.timestamp < Logger.TIME_FRAME:
                return False

            message_node.timestamp = timestamp
            self.dll.move_to_head(message_node)

        else:
            message_node = self.dll.add_head(message, timestamp)
            self.lookup[message] = message_node

            if len(self.lookup) > Logger.TIME_FRAME:
                removed_message = self.dll.remove_tail()
                del self.lookup[removed_message.message]

        return True

class Node:
    def __init__(self, message, timestamp, prev=None, next=None):
        self.message = message
        self.timestamp = timestamp
        self.prev = prev
        self.next = next

class DoublyLinkedList:
    def __init__(self):
        self.head = Node(None, None)
        self.tail = Node(None, None)
        self.head.next = self.tail
        self.tail.prev = self.head

    def add_head(self, message, timestamp):
        node = Node(message, timestamp)
        self.__put_between(self.head, node, self.head.next)
        return node

    def remove_tail(self):
        node = self.tail.prev
        node.prev.next = self.tail
        self.tail.prev = node.prev
        return node

    def move_to_head(self, node):
        self.__put_between(self.head, node, self.head.next)

    def __put_between(self, prev_node, node, next_node):
        prev_node.next = node
        node.prev = prev_node
        node.next = next_node
        next_node.prev = node


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
