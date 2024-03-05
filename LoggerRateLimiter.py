# Time complexity is O(1)
# Space complexity is O(n) n is the number of messages

class Logger:

    def __init__(self):
        self.hashMap = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.hashMap:
            if timestamp - self.hashMap[message] < 10:
                return False
        self.hashMap[message] = timestamp
        return True


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
