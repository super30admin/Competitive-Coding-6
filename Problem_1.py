# https://leetcode.com/problems/logger-rate-limiter/description/

# Time complexity: O(1), 
# Space complexity: O(k), where k is the number of unique messages 
# Explanation: Use a hashmap to store unique messages with current timestamp; only if the diff crosses/equals 10, then update

class Logger:

    def __init__(self):
        self.msg_map = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        # if msg is not seen
        if message not in self.msg_map:
            self.msg_map[message] = timestamp
            return True
        # if msg is seen
        if (timestamp - self.msg_map[message]) >= 10:
            self.msg_map[message] = timestamp
            return True
        else:
            return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
