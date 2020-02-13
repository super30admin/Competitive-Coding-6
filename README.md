# Competitive-Coding-6

// S30 Big N Problem #81 {Easy}
# 784. Letter Case Permutation

This problem was asked at Amazon

 

You are given a string String, you can change every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Assume the following points:

String will be a string with length between 1 and 12.
String will consist only of letters or digits.
Examples:

Input: String = "D1K2"

Output: ["d1k2", "d1K2", "D1k2", "D1K2"]



Input: String = "3A4"

Output: ["3A4", "3a4"]



Input: String = "12345"

Output: ["12345"]



// S30 Big N Problem #82 {Hard}
# 359. Logger Rate Limiter

This problem was asked at Yelp, Facebook

Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

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