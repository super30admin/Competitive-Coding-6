'''
359. Logger Rate Limiter
Problem Link: https://leetcode.com/problems/logger-rate-limiter/description/
'''

# Time Complexity : O(1) for each message check
# Space Complexity : O(N) where N is the number of unique messages
# Did this code successfully run on Leetcode : Yes, it passed all test cases.
# Any problem you faced while coding this : Yes, understanding the timestamp logic was tricky at first, but it became clear that the message should only be printed if it hasn't been printed in the last 10 seconds.


class Logger: # humne Logger class banaya hai jo messages ko track karega (we created a Logger class to track messages)
    '''
    Intuition:
    We need to keep track of the last time each message was printed. If a message is
    printed again within 10 seconds of its last print, we should not print it again and return False.
    If a message is printed for the first time, we should print it and return True.
    For this, we can use a dictionary to map messages to their last printed timestamp.
    We can also use a set to keep track of all messages that have been printed at least once.
    ''' 

    def __init__(self): # humne ek constructor banaya hai jo message_map ko initialize karega (we created a constructor to initialize message_map)
        self.message_map = {}  # yeh ek dictionary hai jo message ko timestamp ke saath map karegi (this is a dictionary that maps messages to their timestamps)

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool: # yeh function check karega ki message ko print karna chahiye ya nahi (this function will check if the message should be printed or not)
        if message in self.message_map and timestamp - self.message_map[message] < 10: # agar message pehle se hai aur timestamp 10 seconds se kam hai toh return False (if the message is already there and the timestamp is less than 10 seconds, return False)
            return False 
        self.message_map[message] = timestamp # agar message pehle se nahi hai ya timestamp 10 seconds se zyada hai toh message ko update karo (if the message is not there or the timestamp is more than 10 seconds, update the message)
        return True # agar message ko print karna hai toh return True (if the message should be printed, return True)


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)