''' 
Time Complexity: O(1)
Space Complexity: O(n)
'''
class Logger:

    def __init__(self):
        self.rate_limit = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.rate_limit:
            time = self.rate_limit[message]
            if time > timestamp:
                return False 
        self.rate_limit[message]=timestamp+10 
        return True 
            
            
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)