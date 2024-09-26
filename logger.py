#Using dictionary to solve this problem
#Time complexity: O(1)
#Space complexity: O(n)
class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict = dict()
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        if message not in self.dict:
            self.dict[message] = timestamp
            return True
        if timestamp - self.dict[message] >=10:
            self.dict[message] = timestamp
            return True
        else:
            return False

obj = Logger()
param_1 = obj.shouldPrintMessage(1,"foo")
print(param_1)