"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating a hashmap to store the message and its timestamp, if the message is not present in hashmap, 
then adding the message to the hashmap, adding 10 to its timestamp and storing as value to the message key
if message already exists in hashmap, then checking if the current timestamps falls between the timestamp at the
message key, if not, returning False, else, updating the timestamp of the message to the current timestamp+10

"""

# Logger rate limiter

class Logger(object):

    def __init__(self):
        self.hmap={}
        

    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message not in self.hmap:
            self.hmap[message]=timestamp+10
            return True
        else:
            if timestamp<self.hmap[message]:
                return False
            else:
                self.hmap[message]=timestamp+10
                return True


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)