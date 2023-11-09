class Logger(object):

    def __init__(self):
        self.res = {}

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message in self.res:
            old_timestamp = self.res[message]
            if timestamp >= old_timestamp + 10:
                self.res[message] = timestamp
                return True
        else:
            self.res[message] = timestamp
            return True

        return False

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)