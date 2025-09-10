class Logger:

    def __init__(self):
        self.hmap={}


    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.hmap:
            self.hmap[message]=timestamp
            return True
        
        else:
            if timestamp>=self.hmap[message]+10:
                self.hmap[message]=timestamp
                return True

        return False   