'''
Approach = Using hashmap
TC = O(1)
SC = O(n)

Question - 359. Logger Rate Limiter
'''

class Logger:

    def __init__(self):
        self.msg_dict = {}

    def shouldPrintMessage(self, timestamp, message):
        if message not in self.msg_dict:
            self.msg_dict[message] = timestamp
            return True
        if timestamp - self.msg_dict[message] >= 10:
            self.msg_dict[message] = timestamp
            return True
        else:
            return False
    
msg = Logger()
print(msg.shouldPrintMessage(1,"FOO"))
print(msg.shouldPrintMessage(2,"BAR"))
print(msg.shouldPrintMessage(3,"FOO"))
print(msg.shouldPrintMessage(8,"BAR"))
print(msg.shouldPrintMessage(10,"FOO"))
print(msg.shouldPrintMessage(11,"FOO"))