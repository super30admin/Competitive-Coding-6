# Time O(1)
# Space O(n)
class Logger:

    def __init__(self):
        self.t_msg_map = defaultdict(int)

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.t_msg_map:
            if timestamp < self.t_msg_map[message] + 10: return False
        self.t_msg_map[message] = timestamp
        return True