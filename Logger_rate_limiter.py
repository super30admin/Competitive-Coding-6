class Logger:
#premium
    def __init__(self):
        """
        Initialize your data structure here.
        """
        #used queue instead of dict to reduce space complexity
        self.win=deque()

    def shouldPrintMessage(self, timestamp, message) :
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        #just mantain queue window within 10 sec 
        while self.win and timestamp-self.win[0][0]>=10:
            self.win.popleft()
        #check if still message exists >that means within 10 sec>false
        for t,m in self.win:
            if message in m:
                return False
        #make queue entry
        self.win.append((timestamp,message))
        return True
            
        
        


# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)