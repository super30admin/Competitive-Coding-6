class Logger:
    # Time Complexity - O(1)
    # Space Complexity - O(m) where m is the size of all incoming messages
    def __init__(self):
        self.dict = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.dict:
            self.dict[message] = timestamp + 10
            return True
        elif message in self.dict:
            x = self.dict[message]
            if timestamp >= x:
                self.dict[message] = timestamp + 10
                return True
            else:
                return False