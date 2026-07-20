#https://www.thes30.com/problem/5d6cbfba18a8450017b7dcc7/solutions
# Time Complexity: O(1) per call one dict lookup, one comparison, one dict write. No loops anywhere.
# Space Complexity: O(m), m is the number of distinct messages ever seen, since entries are never removed.
# Approach:
#   Store the last printed time for every message inside a hashmap.
#   When a message arrives, allow it only if the gap since its last print is 10 or more.
#   If we allow it, overwrite its stored time with the current timestamp.

class Logger:
    def __init__(self):
        self.map = {}                              # message goes to the time it last printed, curly braces make a dict not a set

    def shouldPrintMessage(self, timestamp, message):
        if message in self.map:                    # only need a check when we have printed this message before
            prevTimeStamp = self.map[message]      # the time this exact message last printed
            if timestamp < prevTimeStamp + 10:     # strict less than, a gap of exactly 10 is allowed
                return False                       # still inside the block window, return early and do not touch the map

        self.map[message] = timestamp              # reached only when printing, covers both new message and expired window
        return True                                # message is allowed to print