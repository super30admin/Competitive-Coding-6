# Time Complexity: O(1)
# Space Complexity: O(n)   
# Did this code successfully run on Leetcode : Yes

class Logger(object):

    def __init__(self):
        self.hashmap={}
        

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        msg=message
        if msg in self.hashmap:
            if timestamp>=self.hashmap[msg]+10:
                self.hashmap[msg]=timestamp
                return True
            else:
                return False
        self.hashmap[msg]=timestamp
        return True
        

        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)