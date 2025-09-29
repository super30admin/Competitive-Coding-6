class Logger:

    def __init__(self):
        self.smap={}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.smap:
            prev=self.smap[message]
            if timestamp<prev+10:
                return False
        else:
            self.smap[message]=timestamp
        return True
            
        