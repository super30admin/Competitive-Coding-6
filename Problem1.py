# Problem 1 : Designing of Logger Rate Limiter
# Time Complexity : O(1)
# Space Complexity : O(n) where n is the number of message
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''
# Your code here along with comments explaining your approach
class Logger:
    def __init__(self):
        # initialize hash map which store message as key and timestamp(when can be message printed) as value
        self.hashmap = {}
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        # check if the message is present as key in hash map
        if message in self.hashmap:
            # checking the timestamp is greater than or equal to the value of hashmap for message key
            if timestamp >= self.hashmap[message]:
                # if the value is greater than or equal to then add 10 to timestamp
                newTimestamp = timestamp + 10
                # update the value in hash map with new timestamp
                self.hashmap[message] = newTimestamp
                # return True since we can print the message
                return True
            else:
                # if the value is less then return False since we can not print the message
                return False
        else:
            # if there is no entry in hashmap then create a entry for message and timestamp
            self.hashmap[message] = timestamp + 10
            # return True since we can print the message
            return True
# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)