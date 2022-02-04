# class Logger(object):

#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.timestamps = {}

#     def shouldPrintMessage(self, timestamp, message):
#         """
#         Returns true if the message should be printed in the given timestamp, otherwise returns false.
#         If this method returns false, the message will not be printed.
#         The timestamp is in seconds granularity.
#         :type timestamp: int
#         :type message: str
#         :rtype: bool
#         """
#         if timestamp < self.timestamps.get(message, 0):
#             return False
#         self.timestamps[message] = timestamp + 10
#         return True

#Time: O(N
# space: O(N)
class Logger(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashm = {}


    def shouldPrintMessage(self, timestamp, message):
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message in self.hashm:
            if self.hashm[message] + 10 <= timestamp:
                self.hashm.update({message:timestamp})
                return True
            return False

        else: 
            self.hashm[message] = timestamp
            return True


# Your Logger object will be instantiated and called as such:

obj = Logger()
obj.shouldPrintMessage(1,"hi")
obj.shouldPrintMessage(12,"hi")
obj.shouldPrintMessage(13,"hi")
print(obj.shouldPrintMessage(14,"hi"))

