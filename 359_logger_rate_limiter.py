"""
Design a logger system that receives stream of messages along with its timestamps,
each message should be printed if and only if it is not printed in the last 10 seconds.
Given a message and a timestamp (in seconds granularity),
return true if the message should be printed in the given timestamp, otherwise returns false.
It is possible that several messages arrive roughly at the same time.
Example:

Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true;

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
"""


class Logger:

    def __init__(self):
        self.dic = {}
        self.time_limit = 10

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
            Returns true if the message should be printed in the given timestamp,
            otherwise returns false.
            If this method returns false, the message will not be printed.
            The timestamp is in seconds granularity.

            Time Complexity - O(1)
            Space Complexity - O(n)
                'n' is the number of messages.
        """
        if message in self.dic:
            # message already printed within the timelimit
            if timestamp - self.dic[message] < self.time_limit:
                return False
        self.dic[message] = timestamp
        return True


if __name__ == '__main__':
    logger = Logger()
    print(logger.shouldPrintMessage(1, "foo") == True)
    print(logger.shouldPrintMessage(2, "bar") == True)
    print(logger.shouldPrintMessage(3, "foo") == False)
    print(logger.shouldPrintMessage(8, "bar") == False)
    print(logger.shouldPrintMessage(10, "foo") == False)
    print(logger.shouldPrintMessage(11, "foo") == True)
