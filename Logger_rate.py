"""
Time Complexity : O(1)
Space Complexity : O(L)- length of msgs
Did this code successfully run on Leetcode : I don't have leetcode Premium. I saw the code online and just
Any problem you faced while coding this : no
We can maintain a dictionary with msg as the key and the timestamp when it will expire as its value. So whenever a new msg
comes in, we can compare its timestamp with the timestamp of msg inside dictionary. We will return True if timestamp is greater
and update the timestamp or false if timestamp is less. In case msg is not present inside dictionary, we will insert a new value.
"""

class Logger(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.messageMap = {}
        

    def shouldPrintMessage(self, timestamp, message):
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message not in self.messageMap:
            self.messageMap[message] = timestamp
            return True
        if (timestamp - self.messageMap[message]) >= 10:
            self.messageMap[message] = timestamp
            return True
        else:
            return False
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
