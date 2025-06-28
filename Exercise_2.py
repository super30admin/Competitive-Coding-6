# S30 Problem #81 Designing of Logger Rate Limiter
#LeetCode # https://leetcode.com/problems/logger-rate-limiter/

# Author : Akaash Trivedi
# Time Complexity : O(1) only constant time iteration
# Space Complexity : O(m) m-> unique elements stored in hashmap
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

class Logger:

    def __init__(self):
        self.hashm = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.hashm:
            self.hashm[message] = timestamp
            return True
        
        # check time diff if already in 
        if timestamp - self.hashm[message] >= 10:
            self.hashm[message] = timestamp
            return True
        else:
            return False
