# Time Complexity:O(1) for retriving when i last message printed
# Space Complexity :O(N) where N is number of messages
# Approach:
# Create a dict to get last time stamp for a message
# If message not in dict update dict
# If message exist and current timestamp - last printed message >=10 return true and then update 
# else return false



class Logger:
    """
    @param timestamp: Timestamp
    @param message: Message
    @return: Whether the log can be printed
    """
    def __init__(self):
        self.log_dict = {}
    def could_print_message(self, timestamp: int, message: str) -> bool:
        # --- write your code here ---
        # A message should be printed if 
        # and only if it has not been printed in the last 10 seconds.
        
        if message in  self.log_dict and timestamp-  self.log_dict[message]>=10:
             self.log_dict[message]=timestamp
            return True
        elif message not in  self.log_dict:
             self.log_dict[message]=timestamp
            return True
        else:
            return False

