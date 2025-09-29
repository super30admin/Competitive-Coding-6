class Logger:

    # Time: O(1)
    def __init__(self):
        self.messageHistory = {} 

    # Time: O(L) where L = length of word (HashKey computation to search in map)
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.messageHistory:
            # new message
            self.messageHistory[message] = timestamp
            return True
        else:
            # message present in history
            if timestamp>=self.messageHistory[message]+10:
                # update and return True
                self.messageHistory[message] = timestamp
                return True
            else:
                return False
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)