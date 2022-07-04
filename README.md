# Competitive-Coding-6

#### Beautiful arrangements:
Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
1.	The number at the ith position is divisible by i.
2.	i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?
Example 1:
Input: 2

Output: 2

Explanation: 



The first beautiful arrangement is [1, 2]:



Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).



Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).



The second beautiful arrangement is [2, 1]:



Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).



Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

Note:
1.	N is a positive integer and will not exceed 15.
Source Link: https://leetcode.com/problems/beautiful-arrangement/


#### Logger Rate Limiter
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
Source Link: https://leetcode.com/problems/logger-rate-limiter/
