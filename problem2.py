
# // Time Complexity : O(1)
# // Space Complexity : O(N) as you could add all elements to the hashmap
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Logger:
    def __init__(self):
        self.hashmap={}                                     #initialize a hashmap

    def shouldPrintMessage(self, timestamp, message):
        if(message in self.hashmap):                        #if the message is in the hashmap and the time is greater than 10 seconds, then return true
            if(timestamp - self.hashmap[message] >=10):
                return True
            else:
                return False
        else:
            self.hashmap[message] = timestamp                     #if the message isnt there, then add it to the hashmap 

