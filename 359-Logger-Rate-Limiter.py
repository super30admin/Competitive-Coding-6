# Question: Asks us to design a logger system that receives a stream of messages along with their timestamps and 
#           returns true if the message should be printed in the given timestamp, otherwise returns false. 
#           It should return false if the same message has been printed in the last 10 seconds, otherwise it should return true.

# Time: O(1) which is just for lookup in the hashmap
# space: O(m) where m is the number of unique messages recieved

# When we receive a message and its timestamp we check if it is present in the hashmap if it is then we check if the prev timestap and the current one has a difference of 10 if yes we update the timestamp and return True
# If the message is not the hashmap then we add that message with the timestamp and return True
# If nothing of the above then we return False.

class Logger:
    def __init__(self):
        self.logger = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.logger and timestamp - self.logger[message] >= 10:
            self.logger[message] = timestamp
            return True
        elif message not in self.logger:
            self.logger[message] = timestamp
            return True
        return False