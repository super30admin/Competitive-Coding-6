# TC : O(1)
# SC : O(n) - number of unique messages

class Logger(object):

    def __init__(self):
        self.map = dict()

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """

        if message not in self.map:
            self.map[message] = timestamp
            return True
        if (timestamp - self.map[message]) < 10:
            return False
        else:
            self.map[message] = timestamp
            return True
