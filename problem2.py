# time complexity: O(1)
# space complexity: O(n)
# approach: maintain a dictionary of message and its last printed timestamp. If the message is not in the dictionary, print it and update the timestamp. If the message is in the dictionary, check if the timestamp is greater than or equal to the last printed timestamp + 10. If yes, print the message and update the timestamp. If no, return False.

class Logger:

    def __init__(self):
        self.message_timestamps = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:

        if message not in self.message_timestamps:
            # Message hasn't been printed before; allow printing.
            self.message_timestamps[message] = timestamp
            return True
        else:
            last_timestamp = self.message_timestamps[message]
            if timestamp >= last_timestamp + 10:
                self.message_timestamps[message] = timestamp
                return True
            else:
                return False




# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)