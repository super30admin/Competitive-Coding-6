'''
Time Complexity: O(1)
Space Complexity: O(messages)
'''

class Logger:

    def __init__(self):
        self.di = dict()
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.di:
            self.di[message] = timestamp
            return True
        else:
            if timestamp >= self.di[message] + 10:
                self.di[message] = timestamp
                return True
        return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)