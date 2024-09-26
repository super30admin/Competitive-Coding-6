"""Time complexity-O(1)
Space Complexity-O(n)"""
class Node:
    def __init__(self, message, timestamp):
        self.key=message
        self.value=timestamp
        self.prev=None
        self.next=None
        
class Logger:
    def __init__(self):
        self.map={} 
        self.head=Node("head",0)
        self.tail=Node("tail",0)
        self.head.next=self.tail
        self.tail.prev=self.head
        self.capacity=10

        
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.map:
            nodetoUpdate=self.map[message]
            if abs(nodetoUpdate.value-timestamp)>=10:
                # print(message, timestamp, nodetoUpdate.key, nodetoUpdate.next.value)
                nodetoUpdate.next.prev= nodetoUpdate.prev
                nodetoUpdate.prev.next=nodetoUpdate.next
                nodetoUpdate.value=timestamp
                self.head.next.prev=nodetoUpdate
                nodetoUpdate.next=self.head.next
                self.head.next=nodetoUpdate
                nodetoUpdate.prev=self.head
                self.map[message]=nodetoUpdate
                # self.printLL()
                return True
            else:
                # self.printLL()
                return False
        else:
            if len(self.map)>=self.capacity:
                nodetoRemove=self.tail.prev
                self.tail.prev=self.tail.prev.prev
                self.tail.prev.prev.next=self.tail
                self.map.pop(nodetoRemove.key) 
            newNode=Node(message,timestamp)
            newNode.next=self.head.next
            self.head.next=newNode
            newNode.prev=self.head
            newNode.next.prev=newNode
            self.map[message]=newNode
            # self.printLL()
            return True


    # def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
    #     if message not in self.map:
    #         self.map[message]=timestamp
    #         return True
    #     elif abs(self.map[message]-timestamp)<10:
    #         return False
    #     else:
    #         self.map[message]=timestamp
    #         return True

    # def printLL(self):
    #     print("forward")
    #     temp = self.head
    #     while temp:
    #         print(temp.key, temp.value, end=",")
    #         temp = temp.next
    #     print("")
    #     print("reverse")
    #     temp = self.tail
    #     while temp:
    #         print(temp.key, temp.value, end=",")
    #         temp = temp.prev
    #     print("")

# [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]
sol=Logger()
print(sol.shouldPrintMessage(1, "foo"))
print(sol.shouldPrintMessage(2, "bar"))
print(sol.shouldPrintMessage(3, "foo"))
print(sol.shouldPrintMessage(8, "bar"))
print(sol.shouldPrintMessage(10, "foo"))
print(sol.shouldPrintMessage(11, "foo"))