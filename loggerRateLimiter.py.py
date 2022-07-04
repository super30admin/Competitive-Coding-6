'''
Time Complexity: 0(1) + 0(k) where k is the len of key/value/message that is passed to hash 
Space Complexity: 0(n) -- initlize a dictionary of count of fresh incoming words/message
Run on LeetCode: Yes
'''
class Logger:

    def __init__(self):
        self.__valueTime = {}
        

    def shouldPrintMessage(self, timestamp: int, value: str) -> bool:
        
        if (value not in self.__valueTime) or (value in self.__valueTime and self.__valueTime[value] <= timestamp) :
            self.__valueTime[value] = timestamp + 10
            return True
        
        else:
            return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)