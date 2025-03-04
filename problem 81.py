#  https://leetcode.com/problems/logger-rate-limiter/



# Time Complexity : O(n) for each message, where n is the number of messages in the log.
# Space Complexity : O(n)  # to store timestamps of messages
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Logger:
    def __init__(self):
        self.hm = {}
    
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.hm or timestamp - self.hm[message] <= 10:
            return False
        self.hm[message] = timestamp
        return True
