class Logger:
    
    def __init__(self):
        self.dic = {}

    def shouldPrintMessage(self, timestamp, message):
        if message not in self.dic or self.dic[message] + 10 <= timestamp:
            self.dic[message] = timestamp
            return True
        return False