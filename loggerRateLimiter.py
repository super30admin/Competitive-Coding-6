"""
Keep each message with the last printed timestamp
Check if it's been >=10s since it was printed, on getting a new message
Update timestamp and return True if allowed, else False
"""
"""
Time Complexity: O(1) for both insert and lookup
Space Complexity:O(N) where N - number of unique messages
"""

class loggerRateLimiter:
    def __init__(self):
        self.msg_map = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.msg_map or timestamp - self.msg_map[message] >= 10:
            self.msg_map[message] = timestamp
            return True
        return False

if __name__ == "__main__":
    logger = loggerRateLimiter()
    print(logger.shouldPrintMessage(1, "foo"))   
    print(logger.shouldPrintMessage(2, "bar"))   
    print(logger.shouldPrintMessage(3, "foo"))  
    print(logger.shouldPrintMessage(8, "bar"))   
    print(logger.shouldPrintMessage(10, "foo"))  
    print(logger.shouldPrintMessage(11, "foo"))  
