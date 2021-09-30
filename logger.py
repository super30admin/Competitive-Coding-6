# // Time Complexity :O(1)
# // Space Complexity :O(n), hashmap,queue will be 10
# // Did this code successfully run on Leetcode :no link
# // Any problem you faced while coding this :yes,no link so not able to run properly


# // Your code here along with comments explaining your approach



class Node:
    def __init__(self,time,message):
        self.time=time
        self.msg=message
        self.next=None
        self.prev=None
class Logger:
    def __init__(self):
        self.map={}
        self.head=Node(0,'')
        self.tail=Node(0,'')
        self.head.next=self.tail
        self.tail.prev=self.head
    def should_print_msg(self,timestamp,msg):
        if msg in self.map.keys():
            temp=self.map[msg]
            if (timestamp - temp.time)<10:
                return False
            self.movetohead(temp,timestamp)

        else:
            if len(self.map)>=10:
                self.remove_tail()
                self.addtohead(timestamp,msg)
        return True
    def addtohead(self,timestamp,msg):
        node=Node(timestamp,msg)
        node.next=head.next
        head.next=node
        node.prev=head
        node.next.prev=node
        self.map[msg]=node
    def remove_tail(self):
        temp=self.tail
        self.tail.prev.next=self.tail.next
        self.tail.next.prev=self.tail.prev
        del self.map[temp.msg]
    def movetohead(self,temp,timestamp):
        temp.time=timestamp
        temp.prev.next=temp.next
        temp.next.prev=temp.prev
        temp.next=head.next
        temp.prev=head
        head.next=temp
        temp.next.prev=temp
l=Logger()
l.should_print_msg(1,"foo")
l.should_print_msg(3,"bar")
l.should_print_msg(8,"bar")


    

        
