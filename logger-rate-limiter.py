# tc O(n), sc O(n).
def __init__(self):
    self.map = {} # message: timestamp
    

def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
    if message not in self.map:
        self.map[message] = timestamp
        return True
    else:
        if timestamp >= self.map[message] + 10:
            self.map[message] = timestamp
            return True
        return False