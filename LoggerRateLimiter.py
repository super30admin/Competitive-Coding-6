# Time Complexity: O(1) average
# Space Complexity: O(n) for the hashmap where n is the no.of incoming messages
class Logger:

    def __init__(self):
        self.h = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.h:
            self.h[message] = timestamp
            return True
        if timestamp - self.h[message] >= 10:
            self.h[message] = timestamp
            return True
        else:
            return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)