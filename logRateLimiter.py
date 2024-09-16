# TC O(n) as the message is checked in the hashMap - and to calculate hash of the message 
# it may take O(n) time where n is len of message, although once hash is calculated lookup is O(1)
# SC O(n) where n is number of distinct messages 
class Logger:

    def __init__(self):
        self.allowed = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.allowed:
            lastTimestamp = self.allowed[message]
            if timestamp - lastTimestamp < 10:
                return False
        self.allowed[message] = timestamp
        return True

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)