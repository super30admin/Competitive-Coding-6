# 359. Logger Rate Limiter
# https://leetcode.com/problems/logger-rate-limiter/

# Time Complexity: O(1)
# Space Complexity: O(n)

class Logger:
    def __init__(self):
        self.time_dict = dict()

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.time_dict:
            self.time_dict[message] = timestamp + 10
            return True
        else:
            if self.time_dict[message] <= timestamp:
                self.time_dict[message] = timestamp + 10
                return True
            else:
                return False


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)