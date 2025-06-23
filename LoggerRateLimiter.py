
# // Time Complexity : O(1)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# idea is to maintain a hashmap with key as the message and value as the timestamp for faster retrival 
# as the message comes check if it is already present if so then check if the timestamp incoming is greater than existing timestamp by 10 otherwise return False
# if message is not in hashmap insert it 
# if the timestamp matched the condition update the message timestamp


class Logger:

    def __init__(self):
        self.hashMap = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.hashMap :
            self.hashMap[message] = timestamp
            return True
        if timestamp - self.hashMap[message] >= 10:
            self.hashMap[message] =  timestamp
            return True
        return False
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)