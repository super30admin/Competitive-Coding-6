# Time Complexity: O(1)
# Space Complexity: O(n)

class Logger(object):

    def __init__(self):
        self.dict = {} 

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message in self.dict and timestamp - self.dict[message] < 10:
            return False
        
        else:
            self.dict[message] = timestamp
            return True
        
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
