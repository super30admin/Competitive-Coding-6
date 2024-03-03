class Logger:

    def __init__(self):
        self.my_dict = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.my_dict:
            if timestamp - self.my_dict[message] >= 10:
                self.my_dict[message] = timestamp
                return True
            else:
                return False
        self.my_dict[message] = timestamp
        return True
