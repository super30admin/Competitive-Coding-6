#  Time Complexity : O(1) search and update of hash function takes constant time
#  Space Complexity : O(M) length of incoming messages
#  Did this code successfully run on Leetcode :yes 

class Logger:

    def __init__(self):
        self.msgDict= {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.msgDict:
            self.msgDict[message]=timestamp
            return True
        else:
            if timestamp-self.msgDict[message] >= 10:
                self.msgDict[message] = timestamp
                return True
            else:
                return False

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)