# Time Complexity :average O(1)
# Space Complexity :O(n) all messages
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Logger:

    def __init__(self):
        
        self.d = {}



    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
       imestamp is in seconds granularity.
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
