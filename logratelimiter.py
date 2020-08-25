class Logger(object):

    def __init__(self):
        self._msg_dict = {}
    
    def shouldPrintMessage(self, timestamp, message):
        if message not in self._msg_dict:
            self._msg_dict[message] = timestamp
            return True

        if timestamp - self._msg_dict[message] >= 10:
            self._msg_dict[message] = timestamp
            return True
        else:
            return False
#Time-Complexity: O(1)
#Space-complexity: O(M)