# Time Complexity = O(1)
# Space Complexity = O(n)
class Logger:

    def __init__(self):
        self.hashMap = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.hashMap:
            self.hashMap[message] = timestamp
            return True 
        else:
            prevTime = self.hashMap[message]
            if timestamp - prevTime >= 10:
                self.hashMap[message] = timestamp
                return True
            return False
