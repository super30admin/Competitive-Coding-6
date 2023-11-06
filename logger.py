# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we keep track of the timestamps with message as keys in a hashmap. When a message comes, we check if the messafe is already there in the map, if yes - we check fi the difference
# between new timestamp and already occured timestamp is less than 10. if less than 10 we return flase. else we return true and update map with new timestamo value
class Logger:
    def __init__(self):
        self.lastTime = dict()
    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.lastTime and timestamp - self.lastTime[message] < 10:
            return False
        self.lastTime[message] = timestamp
        return True

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)