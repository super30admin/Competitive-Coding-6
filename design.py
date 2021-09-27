# // Time Complexity : O(1) where k stands for number of unique messages
# // Space Complexity : O(k) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 

class Logger:

    def __init__(self):
        
        self.dict = defaultdict(int)
        
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.dict:
            self.dict[message] = timestamp
            return True
        else:
            if timestamp >= self.dict[message] + 10:
                self.dict[message] = timestamp
                return True
        return False

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)