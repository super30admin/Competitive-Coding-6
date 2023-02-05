# Time Complexity :
# O(N) - number of messages

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We store the earliest print time of the any incoming message in a map. Every time a new message comes, we first check if it's present in the map, if it's not, we store the message and the given timestamp + 10 in the map. If the number is already present in the map, we  check if the given timestamp is greater than equal to what is stored in the map -if it is, then it is added to the map with the new timestamp+10 and we return true. Else we return False

class Logger:
    def __init__(self):
        self.word_time_map = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.word_time_map:
            if timestamp >= self.word_time_map[message]:
                self.word_time_map[message] = timestamp + 10
                return True
            else : 
                return False
        else :
            self.word_time_map[message] = timestamp + 10
            return True
