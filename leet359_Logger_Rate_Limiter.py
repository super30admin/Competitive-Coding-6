# Solution

# // Time Complexity : O(1) since we are directly doing a search on dictionary and checking if time saved against string is
#                      satisfying the condition
# // Space Complexity : O(N) where N is the number of strings we receive
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to save each string with the timestamp it came in with inside a dictionary. Anytime same string comes, we can
# do a search on dicitonary and check if time matches the required criteria. If it matches, then update the current time in
# dictionary and return True

class Logger:

    def __init__(self):
        self.logDict = {}
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message in self.logDict:
            t = self.logDict[message]
            if timestamp >= t+10:
                self.logDict[message] = timestamp
                return True
            else:
                return False
        
        self.logDict[message] = timestamp
        return True

if __name__ == "__main__":
    input = ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
    data = [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
    result = []
    for i in range(len(input)):
        if input[i] == "Logger":
            obj = Logger()
        elif input[i] == "shouldPrintMessage":
            result.append(obj.shouldPrintMessage(data[i][0],data[i][1]))
    
    print(result)