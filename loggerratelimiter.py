#Time Complexity: O(1)
#Space Complexity: O(m) m:messages
class Logger:

    def __init__(self):
        self.dic = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        
        if message not in self.dic:
            self.dic[message] = timestamp
            return True
        
        if timestamp - self.dic[message] >=10:
            self.dic[message] = timestamp
            return True
        else:
            return False
        
