"""
TC - O(1)
SC - O(n)
"""


class Logger:

    def __init__(self):
        self.hMap = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        # base case
        if timestamp is None or message is None: return True

        if message not in self.hMap:
            # {'foo': 11}
            # {'bar': 12}
            self.hMap[message] = timestamp + 10
            return True

        # {'foo': 11} => 11 >= 11 ===> {'foo': 21}
        if timestamp >= self.hMap[message]:
            self.hMap[message] = timestamp + 10
            return True
        else:
            # {'foo': 11} => 3 <= 11
            # {'bar': 12} => 8 <= 12
            # {'foo': 11} => 10 <= 11
            # {'foo': 11} ==> 15 >= 21
            return False

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)