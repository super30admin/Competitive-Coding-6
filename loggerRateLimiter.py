class Logger:
    def __init__(self):
        self.msg_timestamps={}
    
    def shouldPrintMessage(self,timestamp,message):
        if message not in self.msg_timestamps or timestamp >= self.msg_timestamps[message]:
            self.msg_timestamps[message]=timestamp+10
            return True
        return False
    
logger=Logger()
print(logger.shouldPrintMessage(1,"foo"))
print(logger.shouldPrintMessage(2,"bar"))
print(logger.shouldPrintMessage(3,"foo"))
print(logger.shouldPrintMessage(8,"bar"))
print(logger.shouldPrintMessage(10,"foo"))
print(logger.shouldPrintMessage(11,"foo"))
