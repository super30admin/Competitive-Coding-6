class Logger(object):
    # tc : O(1) search in hashmap takes O(1)
    # sc : O(n) where n is the number of messages we receive, all could be new messages so in worst case we have all those messages 
    # ran successfully on leetcode 

    # intution 
    # save the message and its timestamp in a hashmap and if the message is in the map and its timedifference is < 10 seconds then return false 
    # if not return true , if the message is not there then add the message in hashmap and its time and return true 

    def __init__(self):
        self.hash_map = {}
        
    def shouldPrintMessage(self, timestamp, message):
        """
        :type timestamp: int
        :type message: str
        :rtype: bool
        """
        if message in self.hash_map:
            if timestamp - self.hash_map[message] < 10: # atmost 10 seconds
                return False
            else:
                # if not in 10 seconds then we need to update the message with new timestanp as not this is the latest timestamp we saw this message 
                self.hash_map[message] = timestamp
        else:
            self.hash_map[message] = timestamp
            
        return True

        







# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)


