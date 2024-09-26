# T.C. - O(1) 
# S.C. -O(n) n is the number of messages
class Logger:

    def __init__(self):
        self.messages={}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.messages and self.messages[message]+10 <= timestamp:
            self.messages[message]=timestamp
            return True
        elif message not in self.messages:
            self.messages[message]=timestamp
            return True
        return False
# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
