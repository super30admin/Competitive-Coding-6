# The approach uses a dictionary to track the last timestamp each message was printed, 
# ensuring that a message can only be printed if at least 10 seconds have passed since its last occurrence. 
# If the condition is met, the message is updated in the dictionary and allowed to print.

# Time Complexity:
# Time Complexity: O(1) for both inserting and checking the message, as dictionary operations are constant time.
# Space Complexity: O(m), where m is the number of unique messages, as the dictionary stores one entry for each message.

def __init__(self):
    """
    Initialize your data structure here.
    """
    self.dict = {}
        
def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
    """
    Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity.
    """
    if message not in self.dict:
        self.dict[message] = timestamp
        return True
    else:
        if self.dict[message] <= timestamp-10:
            self.dict[message] = timestamp
            return True
        else: return False
			