# To implement double linked list we need a Node, created Node.
class Node:
    def __init__(self, timestamp, message):
        self.timestamp = timestamp
        self.message = message
        self.prev = None
        self.next = None

class Logger:
    # Here, initialized all the pointers in double linked list and also map and size are initialized.
    def __init__(self):
        self.head = Node(0, "")
        self.tail = Node(0, "")
        self.head.next = self.tail
        self.tail.prev = self.head
        self.head.prev = None
        self.tail.next = None
        self.max_time = 10
        self.map = {}

    def shouldPrintMessage(self, timestamp, message) -> int:
        if message in self.map:
            node = self.map[message]
            if timestamp-node.timestamp < self.max_time:
                return False
            self.moveToHead(node,timestamp)
        else:
            if len(map) >= self.max_time:
                self.removeTail()
            self.addToHead(timestamp,message)

    def addToHead(self, timestamp, message):
        newnode = Node(timestamp,message)
        newnode.next = self.head.next
        self.head.next = newnode
        newnode.prev = self.head
        newnode.next.prev = newnode
        self.map[message] = newnode

    def removeTail(self):
        self.tail.prev.next = self.tail.next
        self.tail.next.prev = self.tail.prev
        self.map.pop(self.tail.message, None)

    def moveToHead(self, node, timestamp):
        node.timestamp = timestamp
        node.prev.next = node.next
        node.next.prev = node.prev
        node.next = self.head.next
        node.prev = self.head
        self.head.next = node
        node.next.prev = node



