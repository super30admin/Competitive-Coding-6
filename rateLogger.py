# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : N/A
# Any problem you faced while coding this : No
# Approach: Use a hashmap to store (message : next allowed timestamp).
# If a message is new or the current timestamp >= stored timestamp, print it and update next allowed time (timestamp + 10).
# Otherwise return False since the message was printed within the last 10 seconds.

class Logger:

    def __init__(self):
        self.map = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.map:
            self.map[message] = timestamp + 10
            return True
        if timestamp >= self.map[message]:
            self.map[message] = timestamp + 10
            return True
        return False