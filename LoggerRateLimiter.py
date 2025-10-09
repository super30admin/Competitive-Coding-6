# The time and space complexity is both O(1)

# The logic is simple, just check if the message is there in the dict. If yes, then check if its within time limit of 10s otherwise return False.

class Logger:

    def __init__(self):
        self.message_dict = {}

    def message(self, timestamp: int, message: str) -> bool: # O(1)
        if message not in self.message_dict:
            self.message_dict[message] = timestamp
            return True

        if timestamp - self.message_dict[message] >= 10:
            self.message_dict[message] = timestamp
            return True
        else:
            return False