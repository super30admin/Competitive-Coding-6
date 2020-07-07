"""

    Student : Shahreen Shahjahan Psyche
    Time: O(1) [If I am considering only the searching of the key as constant. Because, my key is string, under the hood the key searching is O(N)]
    Space: O(N) [Where N is the size of my hashmap]

    Passed LC: Yes

"""

class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.records = {} 

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        # if my current message is in my hashmap
        if message in self.records.keys():
            # checking whether message hasbeen encountered within last 10 sec. If yes then returning False or if not then updating the time and 
            # returning True
            difference = timestamp - self.records[message]
            if difference >= 10:
                self.records[message] = timestamp
                return True
            else:
                return False
        else:
            # if my message is not in the list, I am updating the hashmap.
            self.records[message] = timestamp
            return True
        
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)