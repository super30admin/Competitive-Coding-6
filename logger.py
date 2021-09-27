#Time Complexity : O(1)
#Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No




class Logger:
    hashmap = {}
    
    def __init__(self):
        string = ""
        time = None
        Logger.hashmap = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in Logger.hashmap.keys():
            if timestamp < Logger.hashmap[message]:
                return False
            else:
                Logger.hashmap[message] = timestamp + 10
                return True
        else:
            Logger.hashmap[message] = timestamp + 10
            return True


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)