# Time Complexity : O(n), adding and checking strings into hashmap, where n is the length of the message.
# Space Complexity : O(n), The number of messages
# Did this code successfully run on Leetcode : No, no premium sub :(
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# Given a message, if the message is never been received it is added to the hashmap.
# if a message has been printed before, but not in the last 10
# seconds, it is replaced in the hashmap wit the new timestamp
class Logger(object):
    def __init__(self):
        self.store = {}

    def shouldPrintMessage(self, timestamp, message):
        if not message in self.store or timestamp - self.store[message] >= 10:
            self.store[message] = timestamp
            return True
        else:
            return False


# Your Logger object will be instantiated and called as such:
if __name__ == '__main__':
    logger = Logger()
    print logger.shouldPrintMessage(1, "foo") # returns True

    print logger.shouldPrintMessage(2, "bar") # returns True

    print logger.shouldPrintMessage(3, "foo") # returns False

    print logger.shouldPrintMessage(8, "bar") # returns False

    print logger.shouldPrintMessage(10, "foo") # returns False

    print logger.shouldPrintMessage(11, "foo") # returns True
