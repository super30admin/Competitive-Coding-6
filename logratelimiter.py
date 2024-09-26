class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dic = collections.OrderedDict()
        
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
            
        if message in self.dic:
            if self.dic[message] <= timestamp - 10:
                self.dic[message] = timestamp
                self.dic.move_to_end(message)
                return True
            else:
                return False
        
        #removing the obsolete messages
        while self.dic:
            m, t = self.dic.popitem(last=False)
            if t > timestamp-10:
                self.dic[m] = t
                self.dic.move_to_end(m, last=False)
                break
            
                
        self.dic[message] = timestamp
        return True                                                                            #tc is o(1)
                                                                                               #sc is o(1) as we will be having atmost 10 elements in our orderedDic.

# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)
