#Time Complexity - O(1)
#Space Complexity - O(n) when n is the number of incoming messages
#Works on leetcode - yes
#Approach - We use a dictionary to keep track of the messages along with the timestamp. If the message is new or the old timestamp of message
#is more than or equal to 10, we print the message otherwise we don't
class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.logger = dict()
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message in self.logger:
            if (timestamp - self.logger[message]) >=10:
                self.logger[message] = timestamp
                return True
            else:
                
                return False
        else:
            self.logger[message] = timestamp
            return True