'''
-- Passed test cases on LeetCode
'''
class Logger:
    #O(1) - Time complexity as lookup and update in hashmap takes constant time
    #O(n) - space complexity as in n represents the number of messages which are to be stored in the hashmap
    def __init__(self):
        self.dict = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.dict:
            self.dict[message] = timestamp
            return True
        if timestamp - self.dict[message] >= 10:
            self.dict[message] = timestamp
            return True
        return False
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
