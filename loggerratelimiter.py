# Time Complexity : O(1) 
# Space Complexity : O(N) where N is size hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a hashmap to store the message and the timestamp at which it can be printed again.
# If the message is not present in the hashmap, I add it to the hashmap with the timestamp + 10 and return True.
# If the message is present in the hashmap, I check if the current timestamp is greater than or equal to the timestamp in the hashmap.
# If it is, I update the timestamp in the hashmap to the current timestamp + 10 and return True.
# If it is not, I return False.

class Logger:

    def __init__(self):
        self.msg = {}
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.msg:
             self.msg[message] = timestamp + 10
             return True
        else:
            if self.msg[message] <= timestamp:
                self.msg[message] = timestamp +10
                return True
            else:
                return False
         


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)