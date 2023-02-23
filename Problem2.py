# Time Complexity :- O(1)
# Space Complexity :- O(m) where m is the number of new messages that come in

class Logger:

    def __init__(self):
        self.hashMap = {}

        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.hashMap:
            self.hashMap[message] = 10+ timestamp
            return True
        elif message in self.hashMap and self.hashMap[message] <= timestamp:
            self.hashMap[message] = 10+ timestamp
            return True
        return False

        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)