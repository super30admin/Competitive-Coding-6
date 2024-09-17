# Approach: Using hashmap

# Here we will use a hashmap to keep track of the all the unique messages we have printed and the timestamp at which they were printed.
# So whenever a new unique message comes in we just put it in hashmap and return true. But if a same message comes again we check for its timestamp and time at which it was printed before.
# If the difference does not exceed 10sec we do not print it and return false else we retrun true

# Time complexity: O(1)
# Space complexity: O(m); m = max number of unique messages 

class Logger:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hmap = {}
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message not in hmap:
            hmap[message] = timestamp
            return True
        else:
            time = hmap[message]
            if timestamp - time >= 10:
                hmap[message] = timestamp
                return True
            else:
                return False
                
                
# Your Logger object will be instantiated and called as such:
obj = Logger()
param_1 = obj.shouldPrintMessage(timestamp,message)