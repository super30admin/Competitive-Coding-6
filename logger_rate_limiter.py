class Logger:

    def __init__(self):
        self.message_tracker = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:

        if (
            message not in self.message_tracker
            or timestamp - self.message_tracker[message] >= 10
        ):
            self.message_tracker[message] = timestamp

            return True
        else:

            return False


# time complexity is O(1)
# space complexity is O(n)


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
