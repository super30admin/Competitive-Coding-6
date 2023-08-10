#TC O(1) and O(n) SC
class Logger:

    def __init__(self):
        self.hashamp={}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.hashamp and timestamp-self.hashamp[message]<10:
            return False
        else:
            self.hashamp[message]=timestamp
            return True

        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)