---------------------------------Design Logger System-------------------------------------
# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I have used a dict to store all the messages and its timestamps. When we got a should print message request, We will check the 
# dict weather the message is in dict or not. If yes we will check one more condition which is the timestamp diff is greater than or equal to 10 or not.
# If yes we will return True, else False.



class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.d = {}
        
    

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message not in self.d:
            self.d[message] = timestamp
            return True
        else:
            if timestamp-self.d[message] >=10:
                self.d[message] = timestamp
                return True
            else:
                return False
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)