#Problem 3: Logger Rate Limiter
#Time complexity: O(1) for ShouldPrintMessage, or O(n) n length of the word if we consider how hashing is done
#Space complexity: O(n),n number of distinct messages
'''
We keep a hashsmap with the messages as key
and the timestamp as value. Everytime we get a message
we check if it's in hashmap, compare the timestamp. if
we can print it, we update the timestamp.
'''
class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.h={}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message in self.h:
            if timestamp-self.h[message]>=10:
                self.h[message]=timestamp
                return True
            return False
        self.h[message]=timestamp
        return True
